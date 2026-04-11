package t7;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements ServiceConnection {
    public final /* synthetic */ e0 A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap f12259u = new HashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12260v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12261w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public IBinder f12262x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c0 f12263y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ComponentName f12264z;

    public d0(e0 e0Var, c0 c0Var) {
        this.A = e0Var;
        this.f12263y = c0Var;
    }

    public final void a(String str, Executor executor) throws Throwable {
        w7.a aVar;
        Context context;
        this.f12260v = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            e0 e0Var = this.A;
            aVar = e0Var.f12292d;
            context = e0Var.f12290b;
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zD = aVar.d(context, str, this.f12263y.a(context), this, 4225, executor);
            this.f12261w = zD;
            if (zD) {
                this.A.f12291c.sendMessageDelayed(this.A.f12291c.obtainMessage(1, this.f12263y), this.A.f);
            } else {
                this.f12260v = 2;
                try {
                    e0 e0Var2 = this.A;
                    e0Var2.f12292d.c(e0Var2.f12290b, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            StrictMode.setVmPolicy(vmPolicy);
            throw th3;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.A.f12289a) {
            try {
                this.A.f12291c.removeMessages(1, this.f12263y);
                this.f12262x = iBinder;
                this.f12264z = componentName;
                Iterator it = this.f12259u.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f12260v = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.A.f12289a) {
            try {
                this.A.f12291c.removeMessages(1, this.f12263y);
                this.f12262x = null;
                this.f12264z = componentName;
                Iterator it = this.f12259u.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f12260v = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
