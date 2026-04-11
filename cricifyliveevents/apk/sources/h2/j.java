package h2;

import android.media.AudioProfile;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class j {
    public static /* bridge */ /* synthetic */ AudioProfile c(Object obj) {
        return (AudioProfile) obj;
    }

    public static /* bridge */ /* synthetic */ MediaMetricsManager f(Object obj) {
        return (MediaMetricsManager) obj;
    }

    public static /* synthetic */ PlaybackMetrics.Builder g() {
        return new PlaybackMetrics.Builder();
    }

    public static /* synthetic */ PlaybackStateEvent.Builder j() {
        return new PlaybackStateEvent.Builder();
    }
}
