# NewPipeToss

NewPipeToss a fork of [NewPipe-legacy](https://github.com/TeamNewPipe/NewPipe-legacy)
<h2 align="center"><b>NewPipeToss</b></h2>
<h4 align="center">NewPipeToss unified version for legacy devices with up-to-date NewPipeExtractor dependency.</h4>


## Description

This repository contains old version NewPipe-legacy 0.21.1+ with some fixes of. It Reloads [tossj-fork of NewPipe-legacy](https://github.com/tossj/NewPipe-legacy/tree/update-newpipe-extractor-0.21.1) with up-to-date [NewPipeExtractor](https://github.com/TeamNewPipe/NewPipeExtractor) dependency. Upstream NewPipe-legacy is now archived hence this fork.

The application itself heavily relies on the extractor component which is responsible for proper parsing of various video/audio streams, including Youtube site. The old upstream NewPipeLegacy version 0.20.8 depends on old extractor version which is practically deprecated and can't handle current Youtube (and similar?) streams, thus rendering the application useless for daily use.

NewPipeToss version 0.21.1+ in this repository uses the current version of NewPipeExtractor and resolves the forementioned issue, thus making it possible to use old NewPipe-legacy with the current extractor version.

Additionally, direct access to background player window is added to an in-app menu.

NewPipeToss does not use any Google framework libraries, nor the YouTube API. Websites are only parsed to fetch required info, so this app can be used on devices without Google services installed. Also, you don't need a YouTube account to use NewPipe, which is copylefted libre software.

<b>WARNING: THIS IS A BETA VERSION, THEREFORE YOU MAY ENCOUNTER BUGS. IF YOU DO, OPEN AN ISSUE VIA OUR GITHUB REPOSITORY.</b>

<b>PUTTING NEWPIPE OR ANY FORK OF IT INTO THE GOOGLE PLAY STORE VIOLATES THEIR TERMS AND CONDITIONS.</b>

### Features

* Search videos
* Display general info about videos
* Watch YouTube videos
* Listen to YouTube videos
* Popup mode (floating player)
* Select streaming player to watch video with
* Download videos
* Download audio only
* Open a video in Kodi
* Show next/related videos
* Search YouTube in a specific language
* Watch/Block age restricted material
* Display general info about channels
* Search channels
* Watch videos from a channel
* Orbot/Tor support (not yet directly)
* 1080p/2K/4K support
* View history
* Subscribe to channels
* Search history
* Search/watch playlists
* Watch as enqueued playlists
* Enqueue videos
* Local playlists
* Subtitles
* Livestream support
* Show comments

### Supported Services

NewPipe supports multiple services. Our [docs](https://teamnewpipe.github.io/documentation/) provide more info on how a new service can be added to the app and the extractor. Please get in touch with us if you intend to add a new one. Currently supported services are:

* YouTube
* SoundCloud \[beta\]
* media.ccc.de \[beta\]
* PeerTube instances \[beta\]
* Bandcamp \[beta\]

## Updates
When a change to the NewPipe code occurs (due to either adding features or bug fixing), eventually a release will occur. These are in the format x.xx.x . In order to get this new version, you can:
 * Build a debug APK yourself. This is the fastest way to get new features on your device, but is much more complicated, so we recommend using one of the other methods.
 * Download the APK from [releases](https://github.com/RSoulwin/NewPipeToss/releases) and install it.

1. Back up your data via "Settings>Content>Export Database" so you keep your history, subscriptions, and playlists
2. Uninstall NewPipeToss
3. Download the APK from the new source and install it
4. Import the data from step 1 via "Settings>Content>Import Database"

## Contribution
Whether you have ideas, translations, design changes, code cleaning, or real heavy code changes, help is always welcome.
The more is done the better it gets!

If you'd like to get involved, check our [contribution notes](.github/CONTRIBUTING.md).

## Donate
If you like NewPipe we'd be happy about a donation. You can either send bitcoin or donate via Bountysource or Liberapay. For further info on donating to NewPipe, please visit our [website](https://newpipe.schabi.org/donate).

<table>
  <tr>
    <td><img src="https://bitcoin.org/img/icons/logotop.svg" alt="Bitcoin"></td>
    <td><img src="assets/bitcoin_qr_code.png" alt="Bitcoin QR code" width="100px"></td>
    <td><samp>16A9J59ahMRqkLSZjhYj33n9j3fMztFxnh</samp></td>
  </tr>
  <tr>
    <td><a href="https://liberapay.com/TeamNewPipe/"><img src="https://upload.wikimedia.org/wikipedia/commons/2/27/Liberapay_logo_v2_white-on-yellow.svg" alt="Liberapay" width="80px" ></a></td>
    <td><a href="https://liberapay.com/TeamNewPipe/"><img src="assets/liberapay_qr_code.png" alt="Visit NewPipe at liberapay.com" width="100px"></a></td>
    <td><a href="https://liberapay.com/TeamNewPipe/donate"><img src="assets/liberapay_donate_button.svg" alt="Donate via Liberapay" height="35px"></a></td>
  </tr>
  <tr>
    <td><a href="https://www.bountysource.com/teams/newpipe"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Bountysource.png/320px-Bountysource.png" alt="Bountysource" width="190px"></a></td>
    <td><a href="https://www.bountysource.com/teams/newpipe"><img src="assets/bountysource_qr_code.png" alt="Visit NewPipe at bountysource.com" width="100px"></a></td>
    <td><a href="https://www.bountysource.com/teams/newpipe/issues"><img src="https://img.shields.io/bountysource/team/newpipe/activity.svg?colorB=cd201f" height="30px" alt="Check out how many bounties you can earn."></a></td>
  </tr>
</table>

## Privacy Policy

The NewPipe project aims to provide a private, anonymous experience for using media web services.
Therefore, the app does not collect any data without your consent. NewPipe's privacy policy explains in detail what data is sent and stored when you send a crash report, or comment in our blog. You can find the document [here](https://newpipe.schabi.org/legal/privacy/).

## License
[![GNU GPLv3 Image](https://www.gnu.org/graphics/gplv3-127x51.png)](http://www.gnu.org/licenses/gpl-3.0.en.html)  

NewPipe is Free Software: You can use, study share and improve it at your
will. Specifically you can redistribute and/or modify it under the terms of the
[GNU General Public License](https://www.gnu.org/licenses/gpl.html) as
published by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.  
