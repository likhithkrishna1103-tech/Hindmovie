package com.playz.tv.activities;

import a2.o0;
import aa.c1;
import aa.h0;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import c.o;
import com.playz.tv.activities.LandscapeActivity;
import com.playz.tv.app.ProApplication;
import com.playz.tv.services.FloatingPlayer;
import gc.i;
import h.j;
import i4.f0;
import kc.e;
import p1.m1;
import tc.g;
import uc.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class LandscapeActivity extends j {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f3596a0 = 0;
    public ProApplication V;
    public g W;
    public e X;
    public PlayerView Y;
    public b2.g Z;

    @Override // h.j, c.l, e0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        o.a(this);
        super.onCreate(bundle);
        b2.g gVarP = b2.g.p(getLayoutInflater());
        this.Z = gVarP;
        setContentView((RelativeLayout) gVarP.f1737b);
        ProApplication proApplication = (ProApplication) getApplication();
        this.V = proApplication;
        proApplication.f3678v = this;
        b.k(this);
        this.W = FloatingPlayer.E.f3690z;
        PlayerView playerView = (PlayerView) this.Z.f1739d;
        this.Y = playerView;
        e eVarA = e.a(playerView.findViewById(gc.j.player_controls));
        this.X = eVarA;
        this.W.h(this, this.Z, eVarA, true);
        this.X.f7665r.setVisibility(0);
        this.X.f7657j.setImageResource(f0.exo_ic_fullscreen_exit);
        this.X.f7655g.setImageResource(i.ic_back);
        final int i = 0;
        this.X.f7655g.setOnClickListener(new View.OnClickListener(this) { // from class: hc.a

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ LandscapeActivity f6028v;

            {
                this.f6028v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b2.g gVar;
                int i10 = i;
                int i11 = 0;
                LandscapeActivity landscapeActivity = this.f6028v;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        int i12 = LandscapeActivity.f3596a0;
                        landscapeActivity.finish();
                        break;
                    case 1:
                        if (landscapeActivity.W != null && (gVar = landscapeActivity.Z) != null) {
                            ((LinearLayout) gVar.f1738c).setVisibility(8);
                            o0 o0Var = landscapeActivity.W.f;
                            if (o0Var != null && !o0Var.P() && landscapeActivity.W.c()) {
                                o0Var.X();
                            }
                            ga.b.p(landscapeActivity, qc.a.b("fMV0jMC6Nl9dg29dgBHhL29x"), new b2.b(landscapeActivity, 9, o0Var));
                            break;
                        }
                        break;
                    case 2:
                        int resizeMode = landscapeActivity.Y.getResizeMode();
                        if (resizeMode == 0) {
                            landscapeActivity.Y.setResizeMode(3);
                            break;
                        } else if (resizeMode == 3) {
                            landscapeActivity.Y.setResizeMode(4);
                            break;
                        } else if (resizeMode == 4) {
                            landscapeActivity.Y.setResizeMode(0);
                            break;
                        }
                        break;
                    default:
                        o0 o0Var2 = landscapeActivity.W.f;
                        if (o0Var2 != null) {
                            c1 c1Var = lc.n.M0;
                            h0 h0VarListIterator = o0Var2.L().f9952a.listIterator(0);
                            while (h0VarListIterator.hasNext()) {
                                if (lc.n.M0.contains(Integer.valueOf(((m1) h0VarListIterator.next()).f9944b.f9764c))) {
                                    lc.n.T(landscapeActivity.W.f, new c(landscapeActivity, i11)).R(landscapeActivity.o(), null);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        if (this.W.c()) {
            this.W.e();
            ((ProgressBar) this.Z.f1740e).setVisibility(8);
        }
        RecyclerView recyclerView = this.W.f12468g;
        if (recyclerView != null) {
            ViewGroup viewGroup = (ViewGroup) recyclerView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(recyclerView);
            }
            this.X.f7667t.addView(recyclerView);
            this.X.f7667t.setVisibility(0);
        }
        this.X.f7657j.setVisibility(8);
        this.X.f7664q.setVisibility(8);
        this.X.f7668u.setVisibility(8);
        this.X.f7665r.setVisibility(0);
        final int i10 = 2;
        this.X.f7669v.setOnClickListener(new View.OnClickListener(this) { // from class: hc.a

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ LandscapeActivity f6028v;

            {
                this.f6028v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b2.g gVar;
                int i102 = i10;
                int i11 = 0;
                LandscapeActivity landscapeActivity = this.f6028v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        int i12 = LandscapeActivity.f3596a0;
                        landscapeActivity.finish();
                        break;
                    case 1:
                        if (landscapeActivity.W != null && (gVar = landscapeActivity.Z) != null) {
                            ((LinearLayout) gVar.f1738c).setVisibility(8);
                            o0 o0Var = landscapeActivity.W.f;
                            if (o0Var != null && !o0Var.P() && landscapeActivity.W.c()) {
                                o0Var.X();
                            }
                            ga.b.p(landscapeActivity, qc.a.b("fMV0jMC6Nl9dg29dgBHhL29x"), new b2.b(landscapeActivity, 9, o0Var));
                            break;
                        }
                        break;
                    case 2:
                        int resizeMode = landscapeActivity.Y.getResizeMode();
                        if (resizeMode == 0) {
                            landscapeActivity.Y.setResizeMode(3);
                            break;
                        } else if (resizeMode == 3) {
                            landscapeActivity.Y.setResizeMode(4);
                            break;
                        } else if (resizeMode == 4) {
                            landscapeActivity.Y.setResizeMode(0);
                            break;
                        }
                        break;
                    default:
                        o0 o0Var2 = landscapeActivity.W.f;
                        if (o0Var2 != null) {
                            c1 c1Var = lc.n.M0;
                            h0 h0VarListIterator = o0Var2.L().f9952a.listIterator(0);
                            while (h0VarListIterator.hasNext()) {
                                if (lc.n.M0.contains(Integer.valueOf(((m1) h0VarListIterator.next()).f9944b.f9764c))) {
                                    lc.n.T(landscapeActivity.W.f, new c(landscapeActivity, i11)).R(landscapeActivity.o(), null);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        final int i11 = 3;
        this.X.f.setOnClickListener(new View.OnClickListener(this) { // from class: hc.a

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ LandscapeActivity f6028v;

            {
                this.f6028v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b2.g gVar;
                int i102 = i11;
                int i112 = 0;
                LandscapeActivity landscapeActivity = this.f6028v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        int i12 = LandscapeActivity.f3596a0;
                        landscapeActivity.finish();
                        break;
                    case 1:
                        if (landscapeActivity.W != null && (gVar = landscapeActivity.Z) != null) {
                            ((LinearLayout) gVar.f1738c).setVisibility(8);
                            o0 o0Var = landscapeActivity.W.f;
                            if (o0Var != null && !o0Var.P() && landscapeActivity.W.c()) {
                                o0Var.X();
                            }
                            ga.b.p(landscapeActivity, qc.a.b("fMV0jMC6Nl9dg29dgBHhL29x"), new b2.b(landscapeActivity, 9, o0Var));
                            break;
                        }
                        break;
                    case 2:
                        int resizeMode = landscapeActivity.Y.getResizeMode();
                        if (resizeMode == 0) {
                            landscapeActivity.Y.setResizeMode(3);
                            break;
                        } else if (resizeMode == 3) {
                            landscapeActivity.Y.setResizeMode(4);
                            break;
                        } else if (resizeMode == 4) {
                            landscapeActivity.Y.setResizeMode(0);
                            break;
                        }
                        break;
                    default:
                        o0 o0Var2 = landscapeActivity.W.f;
                        if (o0Var2 != null) {
                            c1 c1Var = lc.n.M0;
                            h0 h0VarListIterator = o0Var2.L().f9952a.listIterator(0);
                            while (h0VarListIterator.hasNext()) {
                                if (lc.n.M0.contains(Integer.valueOf(((m1) h0VarListIterator.next()).f9944b.f9764c))) {
                                    lc.n.T(landscapeActivity.W.f, new c(landscapeActivity, i112)).R(landscapeActivity.o(), null);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        ((LinearLayout) this.Z.f1738c).setOnClickListener(new hc.b(0));
        final int i12 = 1;
        ((Button) this.Z.f).setOnClickListener(new View.OnClickListener(this) { // from class: hc.a

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ LandscapeActivity f6028v;

            {
                this.f6028v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b2.g gVar;
                int i102 = i12;
                int i112 = 0;
                LandscapeActivity landscapeActivity = this.f6028v;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        int i122 = LandscapeActivity.f3596a0;
                        landscapeActivity.finish();
                        break;
                    case 1:
                        if (landscapeActivity.W != null && (gVar = landscapeActivity.Z) != null) {
                            ((LinearLayout) gVar.f1738c).setVisibility(8);
                            o0 o0Var = landscapeActivity.W.f;
                            if (o0Var != null && !o0Var.P() && landscapeActivity.W.c()) {
                                o0Var.X();
                            }
                            ga.b.p(landscapeActivity, qc.a.b("fMV0jMC6Nl9dg29dgBHhL29x"), new b2.b(landscapeActivity, 9, o0Var));
                            break;
                        }
                        break;
                    case 2:
                        int resizeMode = landscapeActivity.Y.getResizeMode();
                        if (resizeMode == 0) {
                            landscapeActivity.Y.setResizeMode(3);
                            break;
                        } else if (resizeMode == 3) {
                            landscapeActivity.Y.setResizeMode(4);
                            break;
                        } else if (resizeMode == 4) {
                            landscapeActivity.Y.setResizeMode(0);
                            break;
                        }
                        break;
                    default:
                        o0 o0Var2 = landscapeActivity.W.f;
                        if (o0Var2 != null) {
                            c1 c1Var = lc.n.M0;
                            h0 h0VarListIterator = o0Var2.L().f9952a.listIterator(0);
                            while (h0VarListIterator.hasNext()) {
                                if (lc.n.M0.contains(Integer.valueOf(((m1) h0VarListIterator.next()).f9944b.f9764c))) {
                                    lc.n.T(landscapeActivity.W.f, new c(landscapeActivity, i112)).R(landscapeActivity.o(), null);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
    }

    @Override // h.j, android.app.Activity
    public final void onDestroy() {
        FloatingPlayer floatingPlayer = (FloatingPlayer) this.V.f3679w.f8921v;
        FloatingPlayer floatingPlayer2 = FloatingPlayer.E;
        floatingPlayer.a();
        this.V.f3678v = null;
        super.onDestroy();
    }

    @Override // h.j, android.app.Activity
    public final void onPause() {
        this.W.d();
        super.onPause();
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        if (this.W.c()) {
            this.W.e();
        }
        View view = FloatingPlayer.E.A;
        if (view != null) {
            view.setVisibility(8);
        }
        super.onResume();
    }
}
