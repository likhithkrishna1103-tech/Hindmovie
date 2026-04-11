package r2;

import android.os.Bundle;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import v9.x;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements z9.f, s1.h, o8.a, o8.g, kb.a, z6.e, x, na.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f11319u;

    public /* synthetic */ h(int i) {
        this.f11319u = i;
    }

    public Constructor a() {
        switch (this.f11319u) {
            case 13:
                if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                    return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(w2.o.class).getConstructor(Integer.TYPE);
                }
                return null;
            default:
                return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(w2.o.class).getConstructor(null);
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        ((ExecutorService) obj).shutdown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e7  */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v32, types: [android.text.Spannable, android.text.SpannableString] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r7v2 */
    @Override // z9.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r26) {
        /*
            Method dump skipped, instruction units count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.h.apply(java.lang.Object):java.lang.Object");
    }

    @Override // o8.a
    public Object b(o8.o oVar) throws IOException {
        boolean z2;
        int i;
        Object obj;
        switch (this.f11319u) {
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                if (oVar.j()) {
                    ta.a aVar = (ta.a) oVar.h();
                    qa.c cVar = qa.c.f11167a;
                    cVar.b("Crashlytics report successfully enqueued to DataTransport: " + aVar.f12349b);
                    File file = aVar.f12350c;
                    z2 = true;
                    if (file.delete()) {
                        cVar.b("Deleted report file: " + file.getPath());
                    } else {
                        cVar.f("Crashlytics could not delete report file: " + file.getPath(), null);
                    }
                } else {
                    Log.w("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", oVar.g());
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                i = 403;
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                i = -1;
                break;
            default:
                synchronized (oVar.f9439a) {
                    t7.v.j("Task is not yet complete", oVar.f9441c);
                    if (oVar.f9442d) {
                        throw new CancellationException("Task is already canceled.");
                    }
                    if (IOException.class.isInstance(oVar.f)) {
                        throw ((Throwable) IOException.class.cast(oVar.f));
                    }
                    Exception exc = oVar.f;
                    if (exc != null) {
                        throw new o8.f(exc);
                    }
                    obj = oVar.f9443e;
                }
                Bundle bundle = (Bundle) obj;
                if (bundle == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                String string = bundle.getString("registration_id");
                if (string != null || (string = bundle.getString("unregistered")) != null) {
                    return string;
                }
                String string2 = bundle.getString("error");
                if ("RST".equals(string2)) {
                    throw new IOException("INSTANCE_ID_RESET");
                }
                if (string2 != null) {
                    throw new IOException(string2);
                }
                Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        return Integer.valueOf(i);
    }

    @Override // na.e
    public Object e(zc.c cVar) {
        Set setU = cVar.u(wb.a.class);
        wb.c cVar2 = wb.c.f14086w;
        if (cVar2 == null) {
            synchronized (wb.c.class) {
                try {
                    cVar2 = wb.c.f14086w;
                    if (cVar2 == null) {
                        cVar2 = new wb.c(0);
                        wb.c.f14086w = cVar2;
                    }
                } finally {
                }
            }
        }
        return new wb.b(setU, cVar2);
    }

    @Override // o8.g
    public o8.o r(Object obj) {
        switch (this.f11319u) {
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                ub.t tVar = (ub.t) obj;
                o4.c cVar = FirebaseMessaging.f3572l;
                tVar.getClass();
                ub.q qVar = new ub.q("S", "latestVersion");
                ub.r rVar = tVar.f12896h;
                synchronized (rVar) {
                    rVar.f12882b.k(qVar.f12879c);
                }
                o8.h hVar = new o8.h();
                tVar.a(qVar, hVar);
                o8.o oVar = hVar.f9421a;
                tVar.h();
                return oVar;
            case 22:
                return t1.k(null);
            default:
                return t1.k(null);
        }
    }

    public /* synthetic */ h(int i, Object obj) {
        this.f11319u = i;
    }
}
