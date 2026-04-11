package j2;

import android.os.Build;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements x {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final k f6707u = new k();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final k f6708v = new k();

    public List a(String str, boolean z2, boolean z10) {
        return y.d(str, z2, z10);
    }

    @Override // j2.x
    public int f(Object obj) {
        String str = ((p) obj).f6710a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
