package app.cricfy.tv.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import app.cricfy.tv.activities.LandscapeActivity;
import app.cricfy.tv.app.ProApplication;
import app.cricfy.tv.services.FloatingPlayer;
import c.p;
import com.google.android.gms.internal.measurement.j4;
import d6.k;
import g2.g0;
import h.j;
import m4.f0;
import q5.i;
import u5.d;
import ua.z0;
import v1.m1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class LandscapeActivity extends j {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f1490a0 = 0;
    public ProApplication W;
    public k X;
    public d Y;
    public PlayerView Z;

    @Override // h.j, c.m, h0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        p.a(this);
        super.onCreate(bundle);
        nc.p pVarS = nc.p.s(getLayoutInflater());
        setContentView((RelativeLayout) pVarS.f9069a);
        ProApplication proApplication = (ProApplication) getApplication();
        this.W = proApplication;
        proApplication.f1569w = this;
        j4.t(this);
        this.X = FloatingPlayer.F.A;
        PlayerView playerView = (PlayerView) pVarS.f9070b;
        this.Z = playerView;
        d dVarA = d.a(playerView.findViewById(q5.k.player_controls));
        this.Y = dVarA;
        this.X.f(this, pVarS, dVarA, true);
        ProgressBar progressBar = (ProgressBar) this.Z.findViewById(f0.exo_buffering);
        if (progressBar != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(getColor(i.gray_60), PorterDuff.Mode.SRC_IN);
        }
        k kVar = this.X;
        if (!kVar.f3439t && !kVar.f3440u) {
            kVar.c();
        }
        RecyclerView recyclerView = this.X.f3427g;
        if (recyclerView != null) {
            ViewGroup viewGroup = (ViewGroup) recyclerView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(recyclerView);
            }
            this.Y.f12253m.addView(recyclerView);
            this.Y.f12253m.setVisibility(0);
        }
        this.Y.f12252l.setVisibility(8);
        this.Y.f12246d.setVisibility(8);
        this.Y.f12244b.setVisibility(0);
        this.Y.i.setVisibility(0);
        this.Y.f12250j.setVisibility(0);
        this.Y.f12243a.setVisibility(0);
        this.Y.f.setVisibility(0);
        final int i = 0;
        this.Y.f12244b.setOnClickListener(new View.OnClickListener(this) { // from class: r5.a

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ LandscapeActivity f10854w;

            {
                this.f10854w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i10 = i;
                int i11 = 0;
                LandscapeActivity landscapeActivity = this.f10854w;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        int i12 = LandscapeActivity.f1490a0;
                        landscapeActivity.finish();
                        break;
                    case 1:
                        int resizeMode = landscapeActivity.Z.getResizeMode();
                        if (resizeMode == 0) {
                            landscapeActivity.Z.setResizeMode(3);
                            break;
                        } else if (resizeMode == 3) {
                            landscapeActivity.Z.setResizeMode(4);
                            break;
                        } else if (resizeMode == 4) {
                            landscapeActivity.Z.setResizeMode(0);
                            break;
                        }
                        break;
                    default:
                        g0 g0Var = landscapeActivity.X.f;
                        if (g0Var != null) {
                            z0 z0Var = v5.s.N0;
                            ua.g0 g0VarListIterator = g0Var.G().f12882a.listIterator(0);
                            while (g0VarListIterator.hasNext()) {
                                if (v5.s.N0.contains(Integer.valueOf(((m1) g0VarListIterator.next()).f12873b.f12704c))) {
                                    v5.s.W(landscapeActivity.X.f, new b(landscapeActivity, i11)).U(landscapeActivity.o(), null);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        final int i10 = 1;
        this.Y.f12243a.setOnClickListener(new View.OnClickListener(this) { // from class: r5.a

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ LandscapeActivity f10854w;

            {
                this.f10854w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i10;
                int i11 = 0;
                LandscapeActivity landscapeActivity = this.f10854w;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        int i12 = LandscapeActivity.f1490a0;
                        landscapeActivity.finish();
                        break;
                    case 1:
                        int resizeMode = landscapeActivity.Z.getResizeMode();
                        if (resizeMode == 0) {
                            landscapeActivity.Z.setResizeMode(3);
                            break;
                        } else if (resizeMode == 3) {
                            landscapeActivity.Z.setResizeMode(4);
                            break;
                        } else if (resizeMode == 4) {
                            landscapeActivity.Z.setResizeMode(0);
                            break;
                        }
                        break;
                    default:
                        g0 g0Var = landscapeActivity.X.f;
                        if (g0Var != null) {
                            z0 z0Var = v5.s.N0;
                            ua.g0 g0VarListIterator = g0Var.G().f12882a.listIterator(0);
                            while (g0VarListIterator.hasNext()) {
                                if (v5.s.N0.contains(Integer.valueOf(((m1) g0VarListIterator.next()).f12873b.f12704c))) {
                                    v5.s.W(landscapeActivity.X.f, new b(landscapeActivity, i11)).U(landscapeActivity.o(), null);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        });
        final int i11 = 2;
        this.Y.f12250j.setOnClickListener(new View.OnClickListener(this) { // from class: r5.a

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ LandscapeActivity f10854w;

            {
                this.f10854w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i102 = i11;
                int i112 = 0;
                LandscapeActivity landscapeActivity = this.f10854w;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        int i12 = LandscapeActivity.f1490a0;
                        landscapeActivity.finish();
                        break;
                    case 1:
                        int resizeMode = landscapeActivity.Z.getResizeMode();
                        if (resizeMode == 0) {
                            landscapeActivity.Z.setResizeMode(3);
                            break;
                        } else if (resizeMode == 3) {
                            landscapeActivity.Z.setResizeMode(4);
                            break;
                        } else if (resizeMode == 4) {
                            landscapeActivity.Z.setResizeMode(0);
                            break;
                        }
                        break;
                    default:
                        g0 g0Var = landscapeActivity.X.f;
                        if (g0Var != null) {
                            z0 z0Var = v5.s.N0;
                            ua.g0 g0VarListIterator = g0Var.G().f12882a.listIterator(0);
                            while (g0VarListIterator.hasNext()) {
                                if (v5.s.N0.contains(Integer.valueOf(((m1) g0VarListIterator.next()).f12873b.f12704c))) {
                                    v5.s.W(landscapeActivity.X.f, new b(landscapeActivity, i112)).U(landscapeActivity.o(), null);
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
        FloatingPlayer floatingPlayer = (FloatingPlayer) this.W.f1570x.f986w;
        FloatingPlayer floatingPlayer2 = FloatingPlayer.F;
        floatingPlayer.a();
        this.W.f1569w = null;
        super.onDestroy();
    }

    @Override // h.j, android.app.Activity
    public final void onPause() {
        k kVar = this.X;
        g0 g0Var = kVar.f;
        if (g0Var != null) {
            g0Var.c();
            kVar.f.j(false);
        }
        super.onPause();
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        k kVar = this.X;
        if (!kVar.f3439t && !kVar.f3440u) {
            kVar.c();
        }
        View view = FloatingPlayer.F.B;
        if (view != null) {
            view.setVisibility(8);
        }
        super.onResume();
    }
}
