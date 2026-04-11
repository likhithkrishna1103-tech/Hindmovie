package f9;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 implements ServiceConnection {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f4186v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h1 f4187w;

    public g1(h1 h1Var, String str) {
        Objects.requireNonNull(h1Var);
        this.f4187w = h1Var;
        this.f4186v = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        h1 h1Var = this.f4187w;
        if (iBinder == null) {
            w0 w0Var = h1Var.f4203v.A;
            r1.g(w0Var);
            w0Var.E.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = com.google.android.gms.internal.measurement.a0.f2312d;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            com.google.android.gms.internal.measurement.b0 zVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.measurement.b0 ? (com.google.android.gms.internal.measurement.b0) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.measurement.z(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService", 1);
            r1 r1Var = h1Var.f4203v;
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.J.a("Install Referrer Service connected");
            p1 p1Var = r1Var.B;
            r1.g(p1Var);
            p1Var.v1(new ya.s(this, zVar, this));
        } catch (RuntimeException e9) {
            w0 w0Var3 = h1Var.f4203v.A;
            r1.g(w0Var3);
            w0Var3.E.b(e9, "Exception occurred while calling Install Referrer API");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        w0 w0Var = this.f4187w.f4203v.A;
        r1.g(w0Var);
        w0Var.J.a("Install Referrer Service disconnected");
    }
}
