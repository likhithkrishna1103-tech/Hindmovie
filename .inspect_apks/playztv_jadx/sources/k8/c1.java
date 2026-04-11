package k8;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.p5;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c1 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ d1 f7108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f7109c;

    public /* synthetic */ c1(int i) {
        this.f7107a = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f7107a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                d1 d1Var = this.f7108b;
                String str = this.f7109c;
                g0 g0VarN2 = d1Var.r1().n2(str);
                HashMap map = new HashMap();
                map.put("platform", "android");
                map.put("package_name", str);
                map.put("gmp_version", 106000L);
                if (g0VarN2 != null) {
                    String strH = g0VarN2.h();
                    if (strH != null) {
                        map.put("app_version", strH);
                    }
                    map.put("app_version_int", Long.valueOf(g0VarN2.y()));
                    map.put("dynamite_version", Long.valueOf(g0VarN2.N()));
                }
                return map;
            case 1:
                d1 d1Var2 = this.f7108b;
                String str2 = this.f7109c;
                c1 c1Var = new c1(0);
                c1Var.f7108b = d1Var2;
                c1Var.f7109c = str2;
                return new p5(c1Var);
            default:
                com.google.android.gms.internal.measurement.k4 k4Var = new com.google.android.gms.internal.measurement.k4(this.f7108b, this.f7109c, false);
                com.google.android.gms.internal.measurement.b bVar = new com.google.android.gms.internal.measurement.b("internal.remoteConfig", 1);
                bVar.f3061v.put("getValue", new p5(k4Var));
                return bVar;
        }
    }
}
