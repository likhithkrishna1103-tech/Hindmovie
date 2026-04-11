package f9;

import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z3 extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4517e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z3(Object obj, c2 c2Var, int i) {
        super(c2Var);
        this.f4517e = i;
        this.f = obj;
    }

    @Override // f9.o
    public final void a() {
        switch (this.f4517e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a4 a4Var = (a4) this.f;
                b4 b4Var = (b4) a4Var.f4011y;
                b4Var.m1();
                r1 r1Var = (r1) b4Var.f307w;
                r1Var.F.getClass();
                a4Var.a(SystemClock.elapsedRealtime(), false, false);
                y yVar = r1Var.I;
                r1.d(yVar);
                r1Var.F.getClass();
                yVar.p1(SystemClock.elapsedRealtime());
                break;
            case 1:
                g4 g4Var = (g4) this.f;
                g4Var.q1();
                w0 w0Var = ((r1) g4Var.f307w).A;
                r1.g(w0Var);
                w0Var.J.a("Starting upload from DelayedRunnable");
                g4Var.f4215x.l();
                break;
            default:
                q4 q4Var = (q4) this.f;
                q4Var.a0().m1();
                String str = (String) q4Var.L.pollFirst();
                if (str != null) {
                    q4Var.A0().getClass();
                    q4Var.f4351d0 = SystemClock.elapsedRealtime();
                    q4Var.C().J.b(str, "Sending trigger URI notification to app");
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                    intent.setPackage(str);
                    Context context = q4Var.G.f4363v;
                    if (Build.VERSION.SDK_INT < 34) {
                        context.sendBroadcast(intent);
                    } else {
                        context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                    }
                }
                q4Var.D();
                break;
        }
    }
}
