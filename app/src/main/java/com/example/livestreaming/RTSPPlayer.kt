package com.example.livestreaming

import android.util.Log
import android.view.SurfaceView
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.rtsp.RtspMediaSource
import androidx.media3.ui.PlayerView

@OptIn(UnstableApi::class)
@Composable
fun RTSPPlayer(rtspUrl: String) {
    val context = LocalContext.current

    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            playWhenReady = true
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
        }
    }

    LaunchedEffect(rtspUrl) {
        try {
            val mediaSource = RtspMediaSource.Factory()
                .createMediaSource(MediaItem.fromUri(rtspUrl))
            player.setMediaSource(mediaSource)
            player.prepare()
            Log.d("RTSPPlayer", "RTSP Stream Started: $rtspUrl")
        } catch (e: Exception) {
            Log.e("RTSPPlayer", "Error initializing RTSP stream: ${e.localizedMessage}", e)
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            player.release()
            Log.d("RTSPPlayer", "RTSP Player Released")
        }
    }

    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                useController = true
                this.player = player
                setShowBuffering(PlayerView.SHOW_BUFFERING_WHEN_PLAYING)
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}
