package g4;

import android.media.UnsupportedSchemeException;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.SplashActivity;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s0 implements e1, s1.h, d1, g5.o, f2.s, e.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5204u;

    public /* synthetic */ s0(int i) {
        this.f5204u = i;
    }

    @Override // g5.o
    public void a(g5.n nVar, g5.p pVar) {
        switch (this.f5204u) {
            case 17:
                nVar.a(pVar);
                break;
            case 18:
                nVar.g(pVar);
                break;
            case 19:
                nVar.b(pVar);
                break;
            case 20:
                nVar.c();
                break;
            default:
                nVar.d();
                break;
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        j1 j1Var = (j1) obj;
        switch (this.f5204u) {
            case 1:
                j1Var.K0();
                break;
            case 2:
                j1Var.J0();
                break;
            case 3:
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
            case 9:
            default:
                j1Var.E();
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                j1Var.h0();
                break;
            case 8:
                j1Var.stop();
                break;
            case 10:
                j1Var.d();
                break;
            case 11:
                j1Var.Z();
                break;
        }
    }

    @Override // g4.d1
    public void b(j1 j1Var, s sVar, List list) {
        switch (this.f5204u) {
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                j1Var.u0(list);
                break;
            default:
                j1Var.u0(list);
                break;
        }
    }

    @Override // f2.s
    public f2.u d(UUID uuid) {
        AtomicReference atomicReference = gc.b.f5367e;
        f2.u uVar = (f2.u) atomicReference.getAndSet(null);
        try {
            if (uVar != null) {
                s1.b.g("Pro Pro", "Reusing cached DRM");
                return uVar;
            }
            try {
                gc.b bVar = new gc.b(uuid);
                atomicReference.set(bVar);
                return bVar;
            } catch (UnsupportedSchemeException e10) {
                throw new f2.b0(e10);
            } catch (Exception e11) {
                throw new f2.b0(e11);
            }
        } catch (f2.b0 e12) {
            s1.b.h("CustomFrameworkMediaDrm", "Failed to instantiate DRM for UUID: " + uuid, e12);
            f2.p pVar = new f2.p();
            atomicReference.set(pVar);
            return pVar;
        }
    }

    @Override // g4.e1
    public Object g(b0 b0Var, s sVar, int i) {
        switch (this.f5204u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0Var.getClass();
                throw new ClassCastException();
            case 3:
                q9.e eVar = b0Var.f4960e;
                b0Var.s(sVar);
                eVar.getClass();
                return b8.h.r(new q1(-6));
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                b0Var.getClass();
                throw new ClassCastException();
            case 9:
                b0Var.getClass();
                throw new ClassCastException();
            case 12:
                b0Var.getClass();
                throw new ClassCastException();
            case 14:
                b0Var.getClass();
                throw new ClassCastException();
            default:
                q9.e eVar2 = b0Var.f4960e;
                b0Var.s(sVar);
                eVar2.getClass();
                return b8.h.r(new q1(-6));
        }
    }

    @Override // e.b
    public void j(Object obj) {
        switch (this.f5204u) {
            case 28:
                int i = MainActivity.F0;
                break;
            default:
                int i10 = SplashActivity.f3647g0;
                break;
        }
    }
}
