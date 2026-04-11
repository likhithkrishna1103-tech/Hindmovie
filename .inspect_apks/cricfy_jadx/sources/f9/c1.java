package f9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q4 f4057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4059c;

    public c1(q4 q4Var) {
        o8.u.g(q4Var);
        this.f4057a = q4Var;
    }

    public final void a() {
        q4 q4Var = this.f4057a;
        q4Var.i0();
        q4Var.a0().m1();
        q4Var.a0().m1();
        if (this.f4058b) {
            q4Var.C().J.a("Unregistering connectivity change receiver");
            this.f4058b = false;
            this.f4059c = false;
            try {
                q4Var.G.f4363v.unregisterReceiver(this);
            } catch (IllegalArgumentException e9) {
                q4Var.C().B.b(e9, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        q4 q4Var = this.f4057a;
        q4Var.i0();
        String action = intent.getAction();
        q4Var.C().J.b(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            q4Var.C().E.b(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        a1 a1Var = q4Var.f4354w;
        q4.P(a1Var);
        boolean zG1 = a1Var.G1();
        if (this.f4059c != zG1) {
            this.f4059c = zG1;
            q4Var.a0().v1(new androidx.fragment.app.m(this, zG1));
        }
    }
}
