package b2;

import aa.j0;
import android.media.UnsupportedSchemeException;
import android.os.Bundle;
import android.util.Log;
import cc.h0;
import cc.i0;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;
import f2.b0;
import f2.p;
import f2.s;
import f2.u;
import f2.x;
import g2.q;
import g4.a0;
import g4.e1;
import g4.j1;
import g4.m1;
import g4.r;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements s1.m, z6.g, z6.e, na.e, z9.f, s1.h, f2.m, s, a0, e1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1735u;

    public /* synthetic */ f(int i) {
        this.f1735u = i;
    }

    @Override // s1.m
    public void a(Object obj) {
        ((n) obj).getClass();
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f1735u) {
            case 14:
                ((f2.k) obj).a();
                break;
            case 23:
                ((j1) obj).f();
                break;
            case 24:
                ((j1) obj).H();
                break;
            case 25:
                ((j1) obj).B0();
                break;
            case 26:
                ((j1) obj).M0();
                break;
            case 28:
                ((j1) obj).R0();
                break;
            default:
                ((j1) obj).V();
                break;
        }
    }

    @Override // z6.e, z9.f
    public Object apply(Object obj) {
        switch (this.f1735u) {
            case 2:
                String strI = i0.f2661b.I((h0) obj);
                be.h.d(strI, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
                Log.d("EventGDTLogger", "Session Event: ".concat(strI));
                byte[] bytes = strI.getBytes(ie.a.f6599a);
                be.h.d(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
            case 10:
                return j0.v(Integer.valueOf(((p2.i) obj).f10154u));
            default:
                q qVar = (q) obj;
                qVar.w();
                return j0.r(aa.q.v(qVar.f4908c0.f9179b, new ia.b(8)));
        }
    }

    @Override // g4.a0
    public void b(r rVar, int i) {
        switch (this.f1735u) {
            case 18:
                rVar.getClass();
                break;
            case 19:
                rVar.getClass();
                break;
            default:
                rVar.g(i);
                break;
        }
    }

    @Override // f2.s
    public u d(UUID uuid) {
        try {
            try {
                return new x(uuid);
            } catch (b0 unused) {
                s1.b.g("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
                return new p();
            }
        } catch (UnsupportedSchemeException e10) {
            throw new b0(e10);
        } catch (Exception e11) {
            throw new b0(e11);
        }
    }

    @Override // na.e
    public Object e(zc.c cVar) {
        switch (this.f1735u) {
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return FirebaseSessionsRegistrar.getComponents$lambda$0(cVar);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return FirebaseSessionsRegistrar.getComponents$lambda$1(cVar);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return FirebaseSessionsRegistrar.getComponents$lambda$2(cVar);
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return FirebaseSessionsRegistrar.getComponents$lambda$3(cVar);
            case 8:
                return FirebaseSessionsRegistrar.getComponents$lambda$4(cVar);
            case 9:
                return FirebaseSessionsRegistrar.getComponents$lambda$5(cVar);
            case 10:
            default:
                return TransportRegistrar.lambda$getComponents$2(cVar);
            case 11:
                return TransportRegistrar.lambda$getComponents$0(cVar);
            case 12:
                return TransportRegistrar.lambda$getComponents$1(cVar);
        }
    }

    @Override // g4.e1
    public Object g(g4.b0 b0Var, g4.s sVar, int i) {
        switch (this.f1735u) {
            case 21:
                b0Var.getClass();
                throw new ClassCastException();
            case 22:
                b0Var.getClass();
                throw new ClassCastException();
            default:
                return b0Var.n(sVar);
        }
    }

    public /* synthetic */ f(int i, Object obj) {
        this.f1735u = i;
    }

    public /* synthetic */ f(m1 m1Var, Bundle bundle) {
        this.f1735u = 27;
    }

    public /* synthetic */ f(String str, int i, int i10, g4.o oVar) {
        this.f1735u = 22;
    }

    @Override // f2.m
    public void release() {
    }

    @Override // z6.g
    public void c(Exception exc) {
    }
}
