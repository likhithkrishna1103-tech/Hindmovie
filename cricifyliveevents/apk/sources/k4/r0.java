package k4;

import android.media.UnsupportedSchemeException;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r0 implements y1.h, c1, b1, l2.m, l2.s, l5.m, ta.f, j9.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7156v;

    public /* synthetic */ r0(int i) {
        this.f7156v = i;
    }

    @Override // l5.m
    public void a(l5.l lVar, l5.n nVar) {
        switch (this.f7156v) {
            case 19:
                lVar.e(nVar);
                break;
            case 20:
                lVar.d(nVar);
                break;
            case 21:
                lVar.a(nVar);
                break;
            case 22:
                lVar.c();
                break;
            default:
                lVar.f();
                break;
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f7156v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((h1) obj).K0();
                break;
            case 1:
                ((h1) obj).J0();
                break;
            case 2:
            case 3:
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
            case 11:
            default:
                ((l2.k) obj).a();
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                ((h1) obj).d0();
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                ((h1) obj).stop();
                break;
            case 9:
                ((h1) obj).b();
                break;
            case 10:
                ((h1) obj).V();
                break;
            case 12:
                ((h1) obj).y();
                break;
        }
    }

    @Override // ta.f
    public Object apply(Object obj) {
        m2.r rVar = (m2.r) obj;
        rVar.c();
        return ua.i0.k(ua.q.w(rVar.f8114d0.f11263b, new nc.l(21)));
    }

    @Override // k4.b1
    public void b(h1 h1Var, s sVar, List list) {
        switch (this.f7156v) {
            case 3:
                h1Var.t0(list);
                break;
            default:
                h1Var.t0(list);
                break;
        }
    }

    @Override // j9.a
    public Object c(j9.p pVar) {
        boolean z10;
        int i;
        switch (this.f7156v) {
            case 27:
                if (pVar.j()) {
                    nb.a aVar = (nb.a) pVar.h();
                    kb.c cVar = kb.c.f7396a;
                    cVar.b("Crashlytics report successfully enqueued to DataTransport: " + aVar.f8923b);
                    File file = aVar.f8924c;
                    z10 = true;
                    if (file.delete()) {
                        cVar.b("Deleted report file: " + file.getPath());
                    } else {
                        cVar.f("Crashlytics could not delete report file: " + file.getPath(), null);
                    }
                } else {
                    Log.w("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", pVar.g());
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            case 28:
                i = 403;
                break;
            default:
                i = -1;
                break;
        }
        return Integer.valueOf(i);
    }

    @Override // l2.s
    public l2.u d(UUID uuid) {
        try {
            try {
                try {
                    return new l2.x(uuid);
                } catch (UnsupportedSchemeException e9) {
                    throw new l2.b0(e9);
                }
            } catch (Exception e10) {
                throw new l2.b0(e10);
            }
        } catch (l2.b0 unused) {
            y1.b.g("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new l2.p();
        }
    }

    @Override // k4.c1
    public Object i(b0 b0Var, s sVar, int i) {
        switch (this.f7156v) {
            case 2:
                f9.b0 b0Var2 = b0Var.f6911e;
                b0Var.s(sVar);
                b0Var2.getClass();
                return w1.d.l(new o1(-6));
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                b0Var.getClass();
                throw new ClassCastException();
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                b0Var.getClass();
                throw new ClassCastException();
            case 11:
                b0Var.getClass();
                throw new ClassCastException();
            case 13:
                b0Var.getClass();
                throw new ClassCastException();
            default:
                f9.b0 b0Var3 = b0Var.f6911e;
                b0Var.s(sVar);
                b0Var3.getClass();
                return w1.d.l(new o1(-6));
        }
    }

    public /* synthetic */ r0(int i, Object obj) {
        this.f7156v = i;
    }

    @Override // l2.m
    public void release() {
    }
}
