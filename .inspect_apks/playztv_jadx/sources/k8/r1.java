package k8;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7392u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f7393v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f7394w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f7395x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f7396y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f7397z;

    public /* synthetic */ r1(Object obj, Object obj2, Object obj3, Object obj4, long j5, int i) {
        this.f7392u = i;
        this.f7393v = obj2;
        this.f7394w = obj3;
        this.f7396y = obj4;
        this.f7395x = j5;
        this.f7397z = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7392u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) this.f7394w;
                x3 x3Var = ((o1) this.f7397z).f7348d;
                String str2 = (String) this.f7393v;
                if (str2 != null) {
                    w2 w2Var = new w2(this.f7395x, (String) this.f7396y, str2);
                    x3Var.x().p1();
                    String str3 = x3Var.Z;
                    if (str3 != null) {
                        str3.equals(str);
                    }
                    x3Var.Z = str;
                    x3Var.Y = w2Var;
                } else {
                    x3Var.x().p1();
                    String str4 = x3Var.Z;
                    if (str4 == null || str4.equals(str)) {
                        x3Var.Z = str;
                        x3Var.Y = null;
                    }
                }
                break;
            case 1:
                g2 g2Var = (g2) this.f7397z;
                String str5 = (String) this.f7393v;
                String str6 = (String) this.f7394w;
                g2Var.x1(this.f7395x, this.f7396y, str5, str6);
                break;
            default:
                v2 v2Var = (v2) this.f7397z;
                Bundle bundle = (Bundle) this.f7393v;
                w2 w2Var2 = (w2) this.f7394w;
                w2 w2Var3 = (w2) this.f7396y;
                bundle.remove("screen_name");
                bundle.remove("screen_class");
                v2Var.A1(w2Var2, w2Var3, this.f7395x, true, v2Var.o1().A1("screen_view", bundle, null, false));
                break;
        }
    }
}
