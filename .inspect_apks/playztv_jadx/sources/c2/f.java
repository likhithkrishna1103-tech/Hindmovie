package c2;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.google.android.gms.internal.measurement.k5;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2303e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f2304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f2305h;
    public Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f2306j;

    public f() {
        this.f2300b = new AtomicBoolean();
        this.f2301c = null;
        this.f2302d = new HashMap(16, 1.0f);
        this.f2303e = new HashMap(16, 1.0f);
        this.f = new HashMap(16, 1.0f);
        this.f2304g = new HashMap(16, 1.0f);
        this.f2305h = null;
        this.f2299a = false;
        this.i = new String[0];
        this.f2306j = new k5(2);
    }

    public void a(b bVar) {
        if (!this.f2299a || bVar.equals((b) this.f2305h)) {
            return;
        }
        this.f2305h = bVar;
        e0 e0Var = (e0) ((a2.f0) this.f2301c).f220v;
        Looper looperMyLooper = Looper.myLooper();
        boolean z2 = e0Var.f2277h0 == looperMyLooper;
        StringBuilder sb2 = new StringBuilder("Current looper (");
        sb2.append(looperMyLooper == null ? "null" : looperMyLooper.getThread().getName());
        sb2.append(") is not the playback looper (");
        Looper looper = e0Var.f2277h0;
        sb2.append(looper != null ? looper.getThread().getName() : "null");
        sb2.append(")");
        s1.d.f(sb2.toString(), z2);
        b bVar2 = e0Var.f2296x;
        if (bVar2 == null || bVar.equals(bVar2)) {
            return;
        }
        e0Var.f2296x = bVar;
        n nVar = e0Var.f2291s;
        if (nVar != null) {
            nVar.i();
        }
    }

    public void b(AudioDeviceInfo audioDeviceInfo) {
        wb.c cVar = (wb.c) this.i;
        if (Objects.equals(audioDeviceInfo, cVar == null ? null : (AudioDeviceInfo) cVar.f14088v)) {
            return;
        }
        wb.c cVar2 = audioDeviceInfo != null ? new wb.c(6, audioDeviceInfo) : null;
        this.i = cVar2;
        a(b.c((Context) this.f2300b, (p1.d) this.f2306j, cVar2));
    }

    public f(Context context, a2.f0 f0Var, p1.d dVar, wb.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2300b = applicationContext;
        this.f2301c = f0Var;
        this.f2306j = dVar;
        this.i = cVar;
        int i = s1.b0.f11647a;
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, null);
        this.f2302d = handler;
        this.f2303e = new c(this);
        this.f = new e(0, this);
        b bVar = b.f2243c;
        String str = Build.MANUFACTURER;
        Uri uriFor = (str.equals("Amazon") || str.equals("Xiaomi")) ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        this.f2304g = uriFor != null ? new d(this, handler, applicationContext.getContentResolver(), uriFor) : null;
    }
}
