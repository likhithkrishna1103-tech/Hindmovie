package x5;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.o0;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import c2.v;
import g2.g0;
import java.io.File;
import java.util.Collections;
import java.util.List;
import s2.v0;
import ua.z0;
import v1.a0;
import v1.c0;
import v1.d0;
import v1.j0;
import v1.x;
import v1.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class b extends y {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public b6.f f14330s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public g0 f14331t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f14332u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public String f14333v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final Handler f14334w0 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f14335x0 = 3;

    @Override // androidx.fragment.app.y
    public final void G(View view) {
        c0 c0Var;
        l2.f fVarN;
        l2.n nVar;
        Bundle bundle = this.B;
        if (bundle != null) {
            this.f14332u0 = bundle.getString("arg_ad");
            this.f14333v0 = this.B.getString("arg_action");
        }
        final int i = 0;
        ((View) this.f14330s0.f1803z).setOnClickListener(new View.OnClickListener(this) { // from class: x5.a

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ b f14329w;

            {
                this.f14329w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        b bVar = this.f14329w;
                        try {
                            bVar.Q(new Intent("android.intent.action.VIEW", Uri.parse(bVar.f14333v0)));
                        } catch (ActivityNotFoundException unused) {
                            Toast.makeText(bVar.J(), "Invalid link", 0).show();
                            return;
                        }
                        break;
                    default:
                        b bVar2 = this.f14329w;
                        if (bVar2.f14335x0 <= 0) {
                            bVar2.R();
                        }
                        break;
                }
            }
        });
        ((AppCompatButton) this.f14330s0.f1802y).setEnabled(false);
        final int i10 = 1;
        ((AppCompatButton) this.f14330s0.f1802y).setOnClickListener(new View.OnClickListener(this) { // from class: x5.a

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ b f14329w;

            {
                this.f14329w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        b bVar = this.f14329w;
                        try {
                            bVar.Q(new Intent("android.intent.action.VIEW", Uri.parse(bVar.f14333v0)));
                        } catch (ActivityNotFoundException unused) {
                            Toast.makeText(bVar.J(), "Invalid link", 0).show();
                            return;
                        }
                        break;
                    default:
                        b bVar2 = this.f14329w;
                        if (bVar2.f14335x0 <= 0) {
                            bVar2.R();
                        }
                        break;
                }
            }
        });
        String[] strArrSplit = this.f14332u0.split("\\|");
        if (strArrSplit.length > 1) {
            this.f14332u0 = strArrSplit[0];
            h.j jVarJ = J();
            com.bumptech.glide.n nVarD = com.bumptech.glide.b.d(jVarJ.getApplicationContext()).n().E(this.f14332u0).D(new z5.j(new kb.d(21, this), jVarJ));
            o7.e eVar = new o7.e();
            nVarD.C(eVar, eVar, nVarD, s7.f.f11597b);
        } else {
            g2.l lVar = new g2.l(K());
            lVar.f4791d = true;
            lVar.f4790c = 1;
            g2.p pVar = new g2.p(K());
            pVar.b(lVar);
            g0 g0VarA = pVar.a();
            this.f14331t0 = g0VarA;
            ((PlayerView) this.f14330s0.f1801x).setPlayer(g0VarA);
            ((PlayerView) this.f14330s0.f1801x).setControllerAutoShow(false);
            l4.c0 c0Var2 = new l4.c0(K());
            k8.m mVar = new k8.m();
            mVar.f7281x = new b2.u();
            Context contextK = K();
            if (android.support.v4.media.session.b.f510d == null) {
                android.support.v4.media.session.b.f510d = new v(new File(contextK.getCacheDir(), "media"), new c2.s(), new a2.b(contextK.getApplicationContext(), "exoplayer_internal.db", null, 1));
            }
            mVar.f7280w = android.support.v4.media.session.b.f510d;
            mVar.f7282y = c0Var2;
            mVar.f7279v = 2;
            Uri uri = Uri.parse(this.f14332u0);
            v1.v vVar = new v1.v();
            v1.y yVar = new v1.y();
            List list = Collections.EMPTY_LIST;
            z0 z0Var = z0.f12413z;
            k2.t tVar = new k2.t();
            d0 d0Var = d0.f12622d;
            y1.d.g(yVar.f13038b == null || yVar.f13037a != null);
            if (uri != null) {
                c0Var = new c0(uri, null, yVar.f13037a != null ? new z(yVar) : null, null, list, null, z0Var, -9223372036854775807L);
            } else {
                c0Var = null;
            }
            v1.g0 g0Var = new v1.g0("", new x(vVar), c0Var, new a0(tVar), j0.K, d0Var);
            kb.d dVar = new kb.d(12, new a3.n());
            Object obj = new Object();
            f9.a0 a0Var = new f9.a0(28);
            c0Var.getClass();
            g0Var.f12697b.getClass();
            z zVar = g0Var.f12697b.f12607c;
            if (zVar == null) {
                nVar = l2.n.f7675k;
            } else {
                synchronized (obj) {
                    try {
                        fVarN = zVar.equals(null) ? null : androidx.emoji2.text.v.n(zVar);
                        fVarN.getClass();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                nVar = fVarN;
            }
            v0 v0Var = new v0(g0Var, mVar, dVar, nVar, a0Var, 1048576, null);
            g0 g0Var2 = this.f14331t0;
            g0Var2.P1();
            List listSingletonList = Collections.singletonList(v0Var);
            g0Var2.P1();
            g0Var2.P1();
            g0Var2.H1(listSingletonList, -1, -9223372036854775807L, true);
            this.f14331t0.j(true);
            this.f14331t0.b();
            this.f14331t0.I.a(new d6.j(2, this));
        }
        this.f14334w0.postDelayed(new w2.m(2, this), 1000L);
    }

    public final void R() {
        g0 g0Var = this.f14331t0;
        if (g0Var != null) {
            g0Var.C1();
            this.f14331t0 = null;
        }
        this.f14334w0.removeCallbacksAndMessages(null);
        r0 r0VarL = l();
        Bundle bundle = new Bundle();
        o0 o0Var = (o0) r0VarL.f1053l.get("ad_closed");
        if (o0Var == null || o0Var.f1027v.f1200c.compareTo(androidx.lifecycle.n.f1182y) < 0) {
            r0VarL.f1052k.put("ad_closed", bundle);
        } else {
            o0Var.e(bundle);
        }
        if (r0.J(2)) {
            Log.v("FragmentManager", "Setting fragment result with key ad_closed and result " + bundle);
        }
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(l());
        aVar.h(this);
        aVar.e(true);
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_ad, viewGroup, false);
        int i = q5.k.imageView;
        ImageView imageView = (ImageView) android.support.v4.media.session.b.l(viewInflate, i);
        if (imageView != null) {
            i = q5.k.playerView;
            PlayerView playerView = (PlayerView) android.support.v4.media.session.b.l(viewInflate, i);
            if (playerView != null) {
                i = q5.k.skipButton;
                AppCompatButton appCompatButton = (AppCompatButton) android.support.v4.media.session.b.l(viewInflate, i);
                if (appCompatButton != null) {
                    FrameLayout frameLayout = (FrameLayout) viewInflate;
                    i = q5.k.view;
                    View viewL = android.support.v4.media.session.b.l(viewInflate, i);
                    if (viewL != null) {
                        this.f14330s0 = new b6.f(frameLayout, imageView, playerView, appCompatButton, viewL, 14);
                        return frameLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.fragment.app.y
    public final void y() {
        g0 g0Var = this.f14331t0;
        if (g0Var != null) {
            g0Var.C1();
            this.f14331t0 = null;
        }
        this.f14334w0.removeCallbacksAndMessages(null);
        this.f14330s0 = null;
        this.Z = true;
    }
}
