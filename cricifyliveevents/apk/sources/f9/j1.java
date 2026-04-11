package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.u5;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l1 f4234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4235c;

    public /* synthetic */ j1(l1 l1Var, String str, int i) {
        this.f4233a = i;
        this.f4234b = l1Var;
        this.f4235c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4233a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new com.google.android.gms.internal.measurement.k4(new j1(this.f4234b, this.f4235c, 1));
            case 1:
                l1 l1Var = this.f4234b;
                n nVar = l1Var.f4215x.f4355x;
                q4.P(nVar);
                String str = this.f4235c;
                b1 b1VarO2 = nVar.o2(str);
                HashMap map = new HashMap();
                map.put("platform", "android");
                map.put("package_name", str);
                ((r1) l1Var.f307w).f4366y.r1();
                map.put("gmp_version", 133005L);
                if (b1VarO2 != null) {
                    String strN = b1VarO2.N();
                    if (strN != null) {
                        map.put("app_version", strN);
                    }
                    map.put("app_version_int", Long.valueOf(b1VarO2.P()));
                    map.put("dynamite_version", Long.valueOf(b1VarO2.b()));
                }
                return map;
            default:
                l4.c0 c0Var = new l4.c0(16, this.f4234b, this.f4235c, false);
                u5 u5Var = new u5(0, "internal.remoteConfig");
                u5Var.f2467w.put("getValue", new com.google.android.gms.internal.measurement.k4(u5Var, c0Var));
                return u5Var;
        }
    }
}
