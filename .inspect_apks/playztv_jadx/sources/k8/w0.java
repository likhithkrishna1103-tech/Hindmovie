package k8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x3 f7523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7525c;

    public w0(x3 x3Var) {
        this.f7523a = x3Var;
    }

    public final void a() {
        x3 x3Var = this.f7523a;
        x3Var.e0();
        x3Var.x().p1();
        x3Var.x().p1();
        if (this.f7524b) {
            x3Var.g().I.d("Unregistering connectivity change receiver");
            this.f7524b = false;
            this.f7525c = false;
            try {
                x3Var.F.f7282u.unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                x3Var.g().A.c(e10, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        x3 x3Var = this.f7523a;
        x3Var.e0();
        String action = intent.getAction();
        x3Var.g().I.c(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            x3Var.g().D.c(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        s0 s0Var = x3Var.f7545v;
        x3.y(s0Var);
        boolean zG2 = s0Var.g2();
        if (this.f7525c != zG2) {
            this.f7525c = zG2;
            x3Var.x().y1(new androidx.fragment.app.e(this, zG2));
        }
    }
}
