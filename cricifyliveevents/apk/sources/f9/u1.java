package f9;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 implements Runnable {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4431v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4432w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4433x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ long f4434y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4435z;

    public /* synthetic */ u1(Object obj, String str, String str2, Object obj2, long j4, int i) {
        this.f4431v = i;
        this.f4432w = str;
        this.f4433x = str2;
        this.f4435z = obj2;
        this.f4434y = j4;
        this.A = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4431v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) this.f4433x;
                a2 a2Var = (a2) this.A;
                String str2 = (String) this.f4432w;
                if (str2 != null) {
                    f3 f3Var = new f3(this.f4434y, (String) this.f4435z, str2);
                    q4 q4Var = a2Var.f4001d;
                    q4Var.a0().m1();
                    String str3 = q4Var.f4349b0;
                    if (str3 != null) {
                        str3.equals(str);
                    }
                    q4Var.f4349b0 = str;
                    q4Var.f4348a0 = f3Var;
                } else {
                    q4 q4Var2 = a2Var.f4001d;
                    q4Var2.a0().m1();
                    String str4 = q4Var2.f4349b0;
                    if (str4 == null || str4.equals(str)) {
                        q4Var2.f4349b0 = str;
                        q4Var2.f4348a0 = null;
                    }
                }
                break;
            case 1:
                x2 x2Var = (x2) this.A;
                String str5 = (String) this.f4432w;
                String str6 = (String) this.f4433x;
                x2Var.x1(this.f4434y, this.f4435z, str5, str6);
                break;
            default:
                j3 j3Var = (j3) this.A;
                Bundle bundle = (Bundle) this.f4432w;
                f3 f3Var2 = (f3) this.f4433x;
                f3 f3Var3 = (f3) this.f4435z;
                j3Var.getClass();
                bundle.remove("screen_name");
                bundle.remove("screen_class");
                u4 u4Var = ((r1) j3Var.f307w).D;
                r1.e(u4Var);
                j3Var.w1(f3Var2, f3Var3, this.f4434y, true, u4Var.u1("screen_view", bundle, null, false));
                break;
        }
    }

    public u1(j3 j3Var, Bundle bundle, f3 f3Var, f3 f3Var2, long j4) {
        this.f4431v = 2;
        this.f4432w = bundle;
        this.f4433x = f3Var;
        this.f4435z = f3Var2;
        this.f4434y = j4;
        Objects.requireNonNull(j3Var);
        this.A = j3Var;
    }
}
