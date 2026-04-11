package nc;

import a2.o0;
import aa.c1;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.n0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import java.io.File;
import java.util.Collections;
import java.util.List;
import o2.x0;
import p1.a0;
import p1.b0;
import p1.c0;
import p1.d0;
import p1.g0;
import p1.j0;
import p1.y;
import p1.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends androidx.fragment.app.v {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public ub.o f8922r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public o0 f8923s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f8924t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final String f8925u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final d f8926v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final Handler f8927w0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f8928x0 = 3;

    public e(String str, String str2, d dVar) {
        this.f8924t0 = str;
        this.f8925u0 = str2;
        this.f8926v0 = dVar;
    }

    @Override // androidx.fragment.app.v
    public final void D() {
        c0 c0Var;
        f2.f fVarP;
        f2.n nVar;
        final int i = 0;
        ((View) this.f8922r0.f12871y).setOnClickListener(new View.OnClickListener(this) { // from class: nc.a

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ e f8917v;

            {
                this.f8917v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        e eVar = this.f8917v;
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(eVar.f8925u0));
                            eVar.G().startActivity(intent);
                        } catch (ActivityNotFoundException e10) {
                            Toast.makeText(eVar.G(), e10.getMessage(), 0).show();
                            return;
                        }
                        break;
                    default:
                        e eVar2 = this.f8917v;
                        if (eVar2.f8928x0 <= 0) {
                            eVar2.P();
                        }
                        break;
                }
            }
        });
        final int i10 = 1;
        ((AppCompatButton) this.f8922r0.f12870x).setOnClickListener(new View.OnClickListener(this) { // from class: nc.a

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ e f8917v;

            {
                this.f8917v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        e eVar = this.f8917v;
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(eVar.f8925u0));
                            eVar.G().startActivity(intent);
                        } catch (ActivityNotFoundException e10) {
                            Toast.makeText(eVar.G(), e10.getMessage(), 0).show();
                            return;
                        }
                        break;
                    default:
                        e eVar2 = this.f8917v;
                        if (eVar2.f8928x0 <= 0) {
                            eVar2.P();
                        }
                        break;
                }
            }
        });
        String[] strArrSplit = this.f8924t0.split("\\|");
        if (strArrSplit.length > 1) {
            this.f8924t0 = strArrSplit[0];
            h.j jVarG = G();
            String str = this.f8924t0;
            c cVar = new c(0, this);
            Context applicationContext = jVarG.getApplicationContext();
            x6.f.c(applicationContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
            com.bumptech.glide.k kVarF = com.bumptech.glide.b.a(applicationContext).f2764y.b(applicationContext).n().I(str).F(new pc.j(cVar, jVarG));
            t6.e eVar = new t6.e();
            kVarF.E(eVar, eVar, kVarF, x6.f.f14281b);
        } else {
            a2.n nVar2 = new a2.n(H());
            nVar2.f334d = true;
            nVar2.f333c = 1;
            a2.u uVar = new a2.u(H());
            uVar.b(nVar2);
            o0 o0VarA = uVar.a();
            this.f8923s0 = o0VarA;
            ((PlayerView) this.f8922r0.f12869w).setPlayer(o0VarA);
            ((PlayerView) this.f8922r0.f12869w).setControllerAutoShow(false);
            pb.c cVar2 = new pb.c(H(), 15);
            p7.m mVar = new p7.m();
            mVar.f10285w = new v1.r();
            Context contextH = H();
            if (com.bumptech.glide.c.f2768c == null) {
                com.bumptech.glide.c.f2768c = new w1.u(new File(contextH.getCacheDir(), "media"), new w1.r(), new u1.a(contextH.getApplicationContext(), "exoplayer_internal.db", null, 1));
            }
            mVar.f10284v = com.bumptech.glide.c.f2768c;
            mVar.f10286x = cVar2;
            mVar.f10283u = 2;
            Uri uri = Uri.parse(this.f8924t0);
            p1.w wVar = new p1.w();
            z zVar = new z();
            List list = Collections.EMPTY_LIST;
            c1 c1Var = c1.f650y;
            e2.t tVar = new e2.t();
            d0 d0Var = d0.f9694d;
            s1.d.g(zVar.f10114b == null || zVar.f10113a != null);
            if (uri != null) {
                c0Var = new c0(uri, null, zVar.f10113a != null ? new a0(zVar) : null, null, list, null, c1Var, -9223372036854775807L);
            } else {
                c0Var = null;
            }
            g0 g0Var = new g0("", new y(wVar), c0Var, new b0(tVar), j0.K, d0Var);
            c cVar3 = new c(2, new w2.m());
            Object obj = new Object();
            k8.a0 a0Var = new k8.a0(25);
            c0Var.getClass();
            g0Var.f9757b.getClass();
            a0 a0Var2 = g0Var.f9757b.f9667c;
            if (a0Var2 == null) {
                nVar = f2.n.f4742j;
            } else {
                synchronized (obj) {
                    try {
                        fVarP = a0Var2.equals(null) ? null : a7.b.p(a0Var2);
                        fVarP.getClass();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                nVar = fVarP;
            }
            x0 x0Var = new x0(g0Var, mVar, cVar3, nVar, a0Var, 1048576, null);
            o0 o0Var = this.f8923s0;
            o0Var.S1();
            List listSingletonList = Collections.singletonList(x0Var);
            o0Var.S1();
            o0Var.S1();
            o0Var.K1(listSingletonList, -1, -9223372036854775807L, true);
            this.f8923s0.m(true);
            this.f8923s0.d();
            this.f8923s0.X();
            this.f8923s0.H.a(new hc.q(1, this));
        }
        new Handler(Looper.getMainLooper()).postDelayed(new b(0, this), 1000L);
    }

    public final void P() {
        o0 o0Var = this.f8923s0;
        if (o0Var != null) {
            o0Var.F1();
            this.f8923s0 = null;
        }
        this.f8927w0.removeCallbacksAndMessages(null);
        this.f8926v0.d();
        n0 n0VarO = G().o();
        n0VarO.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n0VarO);
        aVar.g(this);
        aVar.d(false);
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_ad, (ViewGroup) null, false);
        int i = gc.j.imageView;
        ImageView imageView = (ImageView) z7.a.k(viewInflate, i);
        if (imageView != null) {
            i = gc.j.playerView;
            PlayerView playerView = (PlayerView) z7.a.k(viewInflate, i);
            if (playerView != null) {
                i = gc.j.skipButton;
                AppCompatButton appCompatButton = (AppCompatButton) z7.a.k(viewInflate, i);
                if (appCompatButton != null) {
                    FrameLayout frameLayout = (FrameLayout) viewInflate;
                    i = gc.j.view;
                    View viewK = z7.a.k(viewInflate, i);
                    if (viewK != null) {
                        this.f8922r0 = new ub.o(frameLayout, imageView, playerView, appCompatButton, viewK, 21);
                        return frameLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.fragment.app.v
    public final void x() {
        o0 o0Var = this.f8923s0;
        if (o0Var != null) {
            o0Var.F1();
            this.f8923s0 = null;
        }
        this.f8927w0.removeCallbacksAndMessages(null);
        this.Y = true;
    }
}
