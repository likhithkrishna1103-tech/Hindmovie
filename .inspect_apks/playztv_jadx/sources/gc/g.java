package gc;

import a2.o0;
import a2.w;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.media3.ui.PlayerView;
import i4.s;
import i4.x;
import java.util.Formatter;
import java.util.Locale;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements View.OnTouchListener {
    public final PlayerView A;
    public w B;
    public final StringBuilder C;
    public final Formatter D;
    public float E;
    public float F;
    public int G;
    public long H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a1 f5385u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f5386v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f5387w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f5388x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h.j f5389y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final kc.b f5390z;

    public g(h.j jVar, kc.b bVar, PlayerView playerView, o0 o0Var) {
        e eVar = new e(this);
        this.f5386v = eVar;
        this.f5385u = new a1(jVar, eVar);
        if (Build.VERSION.SDK_INT >= 30) {
            Rect bounds = jVar.getWindowManager().getCurrentWindowMetrics().getBounds();
            this.f5387w = bounds.width();
            this.f5388x = bounds.height();
        } else {
            Display defaultDisplay = jVar.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            this.f5387w = point.x;
            this.f5388x = point.y;
        }
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = -1;
        this.H = 0L;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.f5389y = jVar;
        this.f5390z = bVar;
        this.A = playerView;
        this.B = o0Var;
        StringBuilder sb2 = new StringBuilder();
        this.C = sb2;
        this.D = new Formatter(sb2, Locale.getDefault());
        playerView.setControllerVisibilityListener(new wb.c(14, this));
    }

    public final void a(final long j5) {
        final int i = this.G;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: gc.f
            @Override // java.lang.Runnable
            public final void run() {
                x xVar;
                g gVar = this.f5382u;
                PlayerView playerView = gVar.A;
                if (i == gVar.G) {
                    gVar.L = false;
                    ((CardView) gVar.f5390z.f7621w).setVisibility(8);
                    gVar.G = -1;
                    gVar.H = 0L;
                    if (gVar.I) {
                        s sVar = playerView.D;
                        if (sVar != null && (xVar = sVar.f6278u) != null) {
                            xVar.f();
                        }
                        playerView.h(playerView.g());
                    }
                    long j8 = j5;
                    if (j8 != -5) {
                        c3.e eVar = (c3.e) gVar.B;
                        eVar.getClass();
                        eVar.j1(((o0) eVar).d0(), j8, false);
                    }
                }
            }
        }, 1000L);
    }

    public final Rect b() {
        PlayerView playerView = this.A;
        return new Rect(playerView.getLeft(), playerView.getTop(), playerView.getRight(), playerView.getBottom());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x011c  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r20, android.view.MotionEvent r21) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gc.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
