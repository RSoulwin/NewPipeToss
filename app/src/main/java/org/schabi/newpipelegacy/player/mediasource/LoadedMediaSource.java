package org.schabi.newpipelegacy.player.mediasource;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;

import org.schabi.newpipelegacy.player.playqueue.PlayQueueItem;

import java.io.IOException;

public class LoadedMediaSource implements ManagedMediaSource {
    private final MediaSource source;
    private final PlayQueueItem stream;
    private final long expireTimestamp;

    public LoadedMediaSource(@NonNull final MediaSource source, @NonNull final PlayQueueItem stream,
                             final long expireTimestamp) {
        this.source = source;
        this.stream = stream;
        this.expireTimestamp = expireTimestamp;
    }

    public PlayQueueItem getStream() {
        return stream;
    }

    private boolean isExpired() {
        return System.currentTimeMillis() >= expireTimestamp;
    }

    @Override
    public void prepareSource(final MediaSourceCaller mediaSourceCaller,
                              @Nullable final TransferListener mediaTransferListener) {
        source.prepareSource(mediaSourceCaller, mediaTransferListener);
    }

    @Override
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        source.maybeThrowSourceInfoRefreshError();
    }

    @Override
    public void enable(final MediaSourceCaller caller) {
        source.enable(caller);
    }

    @Override
    public MediaPeriod createPeriod(final MediaPeriodId id, final Allocator allocator,
                                    final long startPositionUs) {
        return source.createPeriod(id, allocator, startPositionUs);
    }

    @Override
    public void releasePeriod(final MediaPeriod mediaPeriod) {
        source.releasePeriod(mediaPeriod);
    }

    @Override
    public void disable(final MediaSourceCaller caller) {
        source.disable(caller);
    }

    @Override
    public void releaseSource(final MediaSourceCaller mediaSourceCaller) {
        source.releaseSource(mediaSourceCaller);
    }

    @Override
    public void addEventListener(final Handler handler,
                                 final MediaSourceEventListener eventListener) {
        source.addEventListener(handler, eventListener);
    }

    @Override
    public void removeEventListener(final MediaSourceEventListener eventListener) {
        source.removeEventListener(eventListener);
    }

    /**
     * Adds a {@link DrmSessionEventListener} to the list of listeners which are notified of DRM
     * events for this media source.
     *
     * @param handler       A handler on the which listener events will be posted.
     * @param eventListener The listener to be added.
     */
    @Override
    public void addDrmEventListener(final Handler handler,
                                    final DrmSessionEventListener eventListener) {
        source.addDrmEventListener(handler, eventListener);
    }

    /**
     * Removes a {@link DrmSessionEventListener} from the list of listeners which are notified of
     * DRM events for this media source.
     *
     * @param eventListener The listener to be removed.
     */
    @Override
    public void removeDrmEventListener(final DrmSessionEventListener eventListener) {
        source.removeDrmEventListener(eventListener);
    }

    /**
     * Returns the {@link MediaItem} whose media is provided by the source.
     */
    @Override
    public MediaItem getMediaItem() {
        return source.getMediaItem();
    }

    @Override
    public boolean shouldBeReplacedWith(@NonNull final PlayQueueItem newIdentity,
                                        final boolean isInterruptable) {
        return newIdentity != stream || (isInterruptable && isExpired());
    }

    @Override
    public boolean isStreamEqual(@NonNull final PlayQueueItem otherStream) {
        return this.stream == otherStream;
    }
}
