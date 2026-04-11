package h2;

import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import hb.n;
import java.util.concurrent.ScheduledExecutorService;
import k4.a0;
import k4.b0;
import k4.c1;
import k4.h1;
import k4.k1;
import k4.o;
import k4.r;
import k4.s;
import ua.i0;
import y1.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements m, hc.a, hb.e, ta.f, j9.e, a0, c1, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5493v;

    public /* synthetic */ e(int i) {
        this.f5493v = i;
    }

    @Override // y1.m
    public void a(Object obj) {
        k kVar = (k) obj;
        switch (this.f5493v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                kVar.getClass();
                break;
            case 1:
                kVar.getClass();
                break;
            case 2:
                kVar.getClass();
                break;
            case 3:
                kVar.getClass();
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                kVar.getClass();
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                kVar.getClass();
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                kVar.getClass();
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                kVar.getClass();
                break;
            default:
                kVar.getClass();
                break;
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        h1 h1Var = (h1) obj;
        switch (this.f5493v) {
            case 22:
                h1Var.c();
                break;
            case 23:
                h1Var.D();
                break;
            case 24:
                h1Var.B0();
                break;
            case 25:
                h1Var.M0();
                break;
            case 26:
            default:
                h1Var.S();
                break;
            case 27:
                h1Var.R0();
                break;
        }
    }

    @Override // ta.f
    public Object apply(Object obj) {
        return i0.o(Integer.valueOf(((t2.h) obj).f11858v));
    }

    @Override // k4.a0
    public void b(r rVar, int i) {
        switch (this.f5493v) {
            case 17:
                rVar.getClass();
                break;
            case 18:
                rVar.getClass();
                break;
            default:
                rVar.c(i);
                break;
        }
    }

    @Override // hb.e
    public Object e(dd.c cVar) {
        switch (this.f5493v) {
            case 10:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3024a.get();
            case 11:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3026c.get();
            case 12:
                return (ScheduledExecutorService) ExecutorsRegistrar.f3025b.get();
            case 13:
                n nVar = ExecutorsRegistrar.f3024a;
                return ib.k.f6411v;
            default:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(cVar);
        }
    }

    @Override // k4.c1
    public Object i(b0 b0Var, s sVar, int i) {
        switch (this.f5493v) {
            case 20:
                b0Var.getClass();
                throw new ClassCastException();
            case 21:
                b0Var.getClass();
                throw new ClassCastException();
            case 26:
                return b0Var.n(sVar);
            default:
                b0Var.getClass();
                throw new ClassCastException();
        }
    }

    @Override // j9.e
    public void y(Exception exc) {
        Log.e("FirebaseCrashlytics", "Error fetching settings.", exc);
    }

    public /* synthetic */ e(int i, Object obj) {
        this.f5493v = i;
    }

    public /* synthetic */ e(String str, int i, int i10, o oVar) {
        this.f5493v = 21;
    }

    public /* synthetic */ e(k1 k1Var, Bundle bundle) {
        this.f5493v = 26;
    }

    @Override // hc.a
    public void j(hc.b bVar) {
    }
}
