package nc;

import android.media.UnsupportedSchemeException;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.SplashActivity;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import l2.b0;
import qb.n2;
import s2.x0;
import ua.i0;
import v1.g1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements j9.h, ec.a, j9.a, u7.e, pa.a0, hb.e, l2.s, e.b, ta.f, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9061v;

    public /* synthetic */ l(int i) {
        this.f9061v = i;
    }

    @Override // j9.h
    public j9.p B(Object obj) {
        switch (this.f9061v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = (u) obj;
                l4.a aVar = FirebaseMessaging.f3035l;
                uVar.getClass();
                r rVar = new r("S", "latestVersion");
                s sVar = uVar.f9097h;
                synchronized (sVar) {
                    sVar.f9083b.k(rVar.f9080c);
                }
                j9.i iVar = new j9.i();
                uVar.a(rVar, iVar);
                j9.p pVar = iVar.f6688a;
                uVar.h();
                return pVar;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return vf.g.A(null);
            default:
                return vf.g.A(null);
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        ((x0) obj).f11366b.release();
    }

    @Override // u7.e, ta.f
    public Object apply(Object obj) {
        switch (this.f9061v) {
            case 3:
                oc.e eVar = (oc.e) obj;
                androidx.emoji2.text.v vVar = n.f9065a;
                vVar.getClass();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    vVar.q(eVar, byteArrayOutputStream);
                    break;
                } catch (IOException unused) {
                }
                return byteArrayOutputStream.toByteArray();
            case 18:
                return ((a3.p) obj).a().getClass().getSimpleName();
            case 19:
                return i0.k(ua.q.w(((s2.a0) obj).o().f11263b, new l(21)));
            case 21:
                return Integer.valueOf(((g1) obj).f12704c);
            case 25:
                return Long.valueOf(((x3.c) obj).f14293b);
            case 26:
                return Long.valueOf(((x3.c) obj).f14294c);
            case 27:
                return (u3.q) obj;
            case 28:
                ub.a.f12416b.getClass();
                return rb.a.f10920a.g((n2) obj).getBytes(Charset.forName("UTF-8"));
            default:
                v1.s sVar = (v1.s) obj;
                return sVar.f12986a + ": " + sVar.f12987b;
        }
    }

    @Override // j9.a
    public Object c(j9.p pVar) throws IOException {
        Object obj;
        synchronized (pVar.f6706a) {
            o8.u.i("Task is not yet complete", pVar.f6708c);
            if (pVar.f6709d) {
                throw new CancellationException("Task is already canceled.");
            }
            if (IOException.class.isInstance(pVar.f)) {
                throw ((Throwable) IOException.class.cast(pVar.f));
            }
            Exception exc = pVar.f;
            if (exc != null) {
                throw new j9.g(exc);
            }
            obj = pVar.f6710e;
        }
        Bundle bundle = (Bundle) obj;
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    @Override // l2.s
    public l2.u d(UUID uuid) {
        AtomicReference atomicReference = q5.b.f10362e;
        l2.u uVar = (l2.u) atomicReference.getAndSet(null);
        try {
            if (uVar != null) {
                y1.b.g("Pro Pro", "Reusing cached DRM");
                return uVar;
            }
            try {
                q5.b bVar = new q5.b(uuid);
                atomicReference.set(bVar);
                return bVar;
            } catch (UnsupportedSchemeException e9) {
                throw new b0(e9);
            } catch (Exception e10) {
                throw new b0(e10);
            }
        } catch (b0 e11) {
            y1.b.h("CustomFrameworkMediaDrm", "Failed to instantiate DRM for UUID: " + uuid, e11);
            l2.p pVar = new l2.p();
            atomicReference.set(pVar);
            return pVar;
        }
    }

    @Override // hb.e
    public Object e(dd.c cVar) {
        Set setT = cVar.t(pc.a.class);
        pc.c cVar2 = pc.c.f10179w;
        if (cVar2 == null) {
            synchronized (pc.c.class) {
                try {
                    cVar2 = pc.c.f10179w;
                    if (cVar2 == null) {
                        cVar2 = new pc.c(0);
                        pc.c.f10179w = cVar2;
                    }
                } finally {
                }
            }
        }
        return new pc.b(setT, cVar2);
    }

    @Override // e.b
    public void i(Object obj) {
        switch (this.f9061v) {
            case 10:
                int i = MainActivity.B0;
                break;
            default:
                int i10 = SplashActivity.f1541g0;
                break;
        }
    }

    public /* synthetic */ l(c2.o oVar) {
        this.f9061v = 2;
    }
}
