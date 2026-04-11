package o2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.dash.DashMediaSource$Factory;
import androidx.media3.exoplayer.hls.HlsMediaSource$Factory;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements t7.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9184u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f9185v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f9186w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f9187x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f9188y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f9189z;

    public p(s7.d dVar, r7.a aVar, s7.a aVar2) {
        this.f9189z = dVar;
        this.f9187x = null;
        this.f9188y = null;
        this.f9184u = false;
        this.f9185v = aVar;
        this.f9186w = aVar2;
    }

    public synchronized boolean a() {
        boolean zH;
        Boolean bool = (Boolean) this.f9188y;
        if (bool != null) {
            zH = bool.booleanValue();
        } else {
            try {
                zH = ((ga.g) this.f9185v).h();
            } catch (IllegalStateException unused) {
                zH = false;
            }
        }
        c(zH);
        return zH;
    }

    public z9.l b(int i) {
        z9.l rVar;
        z9.l lVar;
        HashMap map = (HashMap) this.f9186w;
        z9.l lVar2 = (z9.l) map.get(Integer.valueOf(i));
        if (lVar2 != null) {
            return lVar2;
        }
        final pb.c cVar = (pb.c) this.f9188y;
        cVar.getClass();
        if (i != 0) {
            final int i10 = 1;
            if (i != 1) {
                final int i11 = 2;
                if (i != 2) {
                    final int i12 = 3;
                    if (i == 3) {
                        rVar = new a2.r(5, Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(c0.class));
                    } else {
                        if (i != 4) {
                            throw new IllegalArgumentException(e6.j.l("Unrecognized contentType: ", i));
                        }
                        rVar = new z9.l() { // from class: o2.o
                            @Override // z9.l
                            public final Object get() {
                                switch (i12) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        return q.e((Class) this, cVar);
                                    case 1:
                                        return q.e((Class) this, cVar);
                                    case 2:
                                        return q.e((Class) this, cVar);
                                    default:
                                        return new w0(cVar, (w2.m) ((p) this).f9185v);
                                }
                            }
                        };
                    }
                } else {
                    final Class clsAsSubclass = HlsMediaSource$Factory.class.asSubclass(c0.class);
                    lVar = new z9.l() { // from class: o2.o
                        @Override // z9.l
                        public final Object get() {
                            switch (i11) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    return q.e((Class) clsAsSubclass, cVar);
                                case 1:
                                    return q.e((Class) clsAsSubclass, cVar);
                                case 2:
                                    return q.e((Class) clsAsSubclass, cVar);
                                default:
                                    return new w0(cVar, (w2.m) ((p) clsAsSubclass).f9185v);
                            }
                        }
                    };
                }
            } else {
                final Class clsAsSubclass2 = SsMediaSource$Factory.class.asSubclass(c0.class);
                lVar = new z9.l() { // from class: o2.o
                    @Override // z9.l
                    public final Object get() {
                        switch (i10) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                return q.e((Class) clsAsSubclass2, cVar);
                            case 1:
                                return q.e((Class) clsAsSubclass2, cVar);
                            case 2:
                                return q.e((Class) clsAsSubclass2, cVar);
                            default:
                                return new w0(cVar, (w2.m) ((p) clsAsSubclass2).f9185v);
                        }
                    }
                };
            }
            rVar = lVar;
        } else {
            final Class clsAsSubclass3 = DashMediaSource$Factory.class.asSubclass(c0.class);
            final int i13 = 0;
            rVar = new z9.l() { // from class: o2.o
                @Override // z9.l
                public final Object get() {
                    switch (i13) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            return q.e((Class) clsAsSubclass3, cVar);
                        case 1:
                            return q.e((Class) clsAsSubclass3, cVar);
                        case 2:
                            return q.e((Class) clsAsSubclass3, cVar);
                        default:
                            return new w0(cVar, (w2.m) ((p) clsAsSubclass3).f9185v);
                    }
                }
            };
        }
        map.put(Integer.valueOf(i), rVar);
        return rVar;
    }

    public void c(boolean z2) {
        String str = "Crashlytics automatic data collection " + (z2 ? "ENABLED" : "DISABLED") + " by " + (((Boolean) this.f9188y) == null ? "global Firebase setting" : this.f9184u ? "firebase_crashlytics_collection_enabled manifest flag" : "API") + ".";
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public void d(q7.b bVar) {
        s7.j jVar = (s7.j) ((s7.d) this.f9189z).D.get((s7.a) this.f9186w);
        if (jVar != null) {
            t7.v.b(jVar.f11898n.G);
            r7.a aVar = jVar.f11891e;
            aVar.d("onSignInFailed for " + aVar.getClass().getName() + " with " + String.valueOf(bVar));
            jVar.o(bVar, null);
        }
    }

    @Override // t7.d
    public void m(q7.b bVar) {
        ((s7.d) this.f9189z).G.post(new p7.i(this, 3, bVar));
    }

    public p(ga.g gVar) {
        Boolean boolValueOf;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        this.f9186w = new Object();
        this.f9187x = new o8.h();
        this.f9184u = false;
        this.f9189z = new o8.h();
        gVar.a();
        Context context = gVar.f5346a;
        this.f9185v = gVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.crashlytics", 0);
        if (sharedPreferences.contains("firebase_crashlytics_collection_enabled")) {
            this.f9184u = false;
            boolValueOf = Boolean.valueOf(sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        if (boolValueOf == null) {
            try {
                packageManager = context.getPackageManager();
            } catch (PackageManager.NameNotFoundException e10) {
                Log.e("FirebaseCrashlytics", "Could not read data collection permission from manifest", e10);
            }
            Boolean boolValueOf2 = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
            if (boolValueOf2 == null) {
                this.f9184u = false;
                boolValueOf = null;
            } else {
                this.f9184u = true;
                boolValueOf = Boolean.valueOf(Boolean.TRUE.equals(boolValueOf2));
            }
        }
        this.f9188y = boolValueOf;
        synchronized (this.f9186w) {
            try {
                if (a()) {
                    ((o8.h) this.f9187x).c(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public p(w2.m mVar, k8.b0 b0Var) {
        this.f9185v = mVar;
        this.f9189z = b0Var;
        this.f9186w = new HashMap();
        this.f9187x = new HashMap();
        this.f9184u = true;
    }
}
