package p2;

import android.os.Build;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final j f9922v = new j();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f9923w = new j();

    public List a(String str, boolean z10, boolean z11) {
        return x.d(str, z10, z11);
    }

    @Override // p2.w
    public int e(Object obj) {
        String str = ((o) obj).f9925a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
