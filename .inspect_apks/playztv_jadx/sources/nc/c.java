package nc;

import aa.c1;
import aa.g0;
import aa.j0;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.av1.Dav1dDecoder;
import androidx.media3.ui.PlayerView;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import k8.a0;
import p1.g1;
import q0.o0;
import q0.o1;
import q0.r1;
import ub.y;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements pc.k, na.e, nb.a, r2.m, q0.p, s1.h, o8.a, y1.g, o8.c, o8.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8920u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f8921v;

    public /* synthetic */ c(int i, Object obj) {
        this.f8920u = i;
        this.f8921v = obj;
    }

    @Override // o8.c
    public void A(o8.o oVar) {
        switch (this.f8920u) {
            case 16:
                ub.w.b((Intent) this.f8921v);
                break;
            case 17:
                ((y) this.f8921v).f12910b.c(null);
                break;
            default:
                ((ScheduledFuture) this.f8921v).cancel(false);
                break;
        }
    }

    @Override // q0.p
    public r1 C(View view, r1 r1Var) {
        t0.g gVar = (t0.g) this.f8921v;
        ArrayList arrayList = gVar.f11990b;
        o1 o1Var = r1Var.f10492a;
        i0.d dVarB = i0.d.b(o1Var.f(519), o1Var.f(64));
        i0.d dVarB2 = i0.d.b(o1Var.g(519), o1Var.g(64));
        if (!dVarB.equals(gVar.f11991c) || !dVarB2.equals(gVar.f11992d)) {
            gVar.f11991c = dVarB;
            gVar.f11992d = dVarB2;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                t0.c cVar = (t0.c) arrayList.get(size);
                cVar.f11979c = dVarB;
                cVar.f11980d = dVarB2;
                cVar.c();
            }
        }
        return r1Var;
    }

    @Override // y1.g
    public void a(y1.h hVar) {
        switch (this.f8920u) {
            case 13:
                u3.i iVar = (u3.i) this.f8921v;
                u3.h hVar2 = (u3.h) hVar;
                hVar2.clear();
                iVar.f12757b.add(hVar2);
                break;
            default:
                ((Dav1dDecoder) this.f8921v).releaseOutputBuffer((VideoDecoderOutputBuffer) hVar);
                break;
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f8920u) {
            case 9:
                t3.h hVar = (t3.h) this.f8921v;
                t3.a aVar = (t3.a) obj;
                t3.g gVar = new t3.g(aVar.f12072b, a0.h(aVar.f12071a, aVar.f12073c));
                hVar.f12083c.add(gVar);
                long j5 = hVar.f12088j;
                if (j5 == -9223372036854775807L || aVar.f12074d >= j5) {
                    hVar.b(gVar);
                }
                break;
            default:
                ((g0) this.f8921v).a((t3.a) obj);
                break;
        }
    }

    @Override // o8.a
    public Object b(o8.o oVar) {
        switch (this.f8920u) {
            case 11:
                ((CountDownLatch) this.f8921v).countDown();
                return null;
            case 14:
                return (o8.o) ((ta.k) this.f8921v).call();
            default:
                ((Runnable) this.f8921v).run();
                return t1.k(null);
        }
    }

    @Override // nb.a
    public void c(nb.b bVar) {
        switch (this.f8920u) {
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                qa.a aVar = (qa.a) this.f8921v;
                aVar.getClass();
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Crashlytics native component now available.", null);
                }
                aVar.f11165b.set((qa.a) bVar.get());
                break;
            default:
                qa.b bVar2 = (qa.b) this.f8921v;
                z0.i iVar = ((xb.i) ((ac.a) bVar.get())).a().f14343k;
                ((Set) iVar.f14764d).add(bVar2);
                o8.o oVarB = ((yb.c) iVar.f14761a).b();
                oVarB.d((Executor) iVar.f14763c, new dd.e(iVar, oVarB, bVar2, 14));
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Registering RemoteConfig Rollouts subscriber", null);
                }
                break;
        }
    }

    @Override // pc.k
    public void d(Drawable drawable, boolean z2) {
        e eVar = (e) this.f8921v;
        if (!z2) {
            eVar.P();
            return;
        }
        ((ImageView) eVar.f8922r0.f12868v).setVisibility(0);
        ((PlayerView) eVar.f8922r0.f12869w).setVisibility(8);
        ((ImageView) eVar.f8922r0.f12868v).setImageDrawable(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x058c A[Catch: Exception -> 0x05b9, TryCatch #1 {Exception -> 0x05b9, blocks: (B:115:0x048a, B:117:0x0560, B:118:0x0565, B:120:0x058c, B:122:0x0594, B:124:0x05a2, B:126:0x05a8, B:128:0x05b1, B:129:0x05b5), top: B:157:0x048a }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05c4  */
    @Override // na.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(zc.c r57) {
        /*
            Method dump skipped, instruction units count: 1649
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.c.e(zc.c):java.lang.Object");
    }

    public boolean f(u5.d dVar, int i, Bundle bundle) {
        q0.c cVar;
        n.v vVar = (n.v) this.f8921v;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 25 && (i & 1) != 0) {
            try {
                ((s0.g) dVar.f12784v).e();
                Parcelable parcelable = (Parcelable) ((s0.g) dVar.f12784v).c();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e10) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e10);
                return false;
            }
        }
        s0.g gVar = (s0.g) dVar.f12784v;
        ClipData clipData = new ClipData(gVar.a(), new ClipData.Item(gVar.d()));
        if (i10 >= 31) {
            cVar = new o4.c(clipData, 2);
        } else {
            q0.d dVar2 = new q0.d();
            dVar2.f10429v = clipData;
            dVar2.f10430w = 2;
            cVar = dVar2;
        }
        cVar.o(gVar.h());
        cVar.setExtras(bundle);
        return o0.j(vVar, cVar.build()) == null;
    }

    @Override // r2.m
    public c1 g(int i, g1 g1Var, int[] iArr) {
        r2.j jVar = (r2.j) this.f8921v;
        g0 g0VarN = j0.n();
        for (int i10 = 0; i10 < g1Var.f9762a; i10++) {
            g0VarN.a(new r2.f(i, g1Var, i10, jVar, iArr[i10]));
        }
        return g0VarN.g();
    }

    @Override // o8.g
    public o8.o r(Object obj) {
        return t1.k((yb.f) this.f8921v);
    }
}
