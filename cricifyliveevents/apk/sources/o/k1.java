package o;

import android.graphics.RenderNode;
import android.media.MediaCodecInfo;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class k1 {
    public static /* synthetic */ RenderNode c() {
        return new RenderNode("OffscreenLayer.main");
    }

    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint e() {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60);
    }

    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint f(int i, int i10, int i11) {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i10, i11);
    }

    public static /* bridge */ /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint g(Object obj) {
        return (MediaCodecInfo.VideoCapabilities.PerformancePoint) obj;
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ RenderNode u() {
        return new RenderNode("OffscreenLayer.shadow");
    }
}
