package q5;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.media3.ui.PlayerView;
import g2.g0;
import g2.r;
import java.util.Formatter;
import java.util.Locale;
import m4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements View.OnTouchListener {
    public final l7.a A;
    public final PlayerView B;
    public r C;
    public final StringBuilder D;
    public final Formatter E;
    public float F;
    public float G;
    public int H;
    public long I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l4.a f10380v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f10381w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f10382x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f10383y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final h.j f10384z;

    public g(h.j jVar, l7.a aVar, PlayerView playerView, g0 g0Var) {
        e eVar = new e(this);
        this.f10381w = eVar;
        this.f10380v = new l4.a(jVar, eVar);
        if (Build.VERSION.SDK_INT >= 30) {
            Rect bounds = jVar.getWindowManager().getCurrentWindowMetrics().getBounds();
            this.f10382x = bounds.width();
            this.f10383y = bounds.height();
        } else {
            Display defaultDisplay = jVar.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            this.f10382x = point.x;
            this.f10383y = point.y;
        }
        this.F = -1.0f;
        this.G = -1.0f;
        this.H = -1;
        this.I = 0L;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.f10384z = jVar;
        this.A = aVar;
        this.B = playerView;
        this.C = g0Var;
        StringBuilder sb = new StringBuilder();
        this.D = sb;
        this.E = new Formatter(sb, Locale.getDefault());
        playerView.setControllerVisibilityListener(new kf.i(13, this));
    }

    public final void a(final long j4) {
        final int i = this.H;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: q5.f
            @Override // java.lang.Runnable
            public final void run() {
                v vVar;
                g gVar = this.f10377v;
                PlayerView playerView = gVar.B;
                if (i == gVar.H) {
                    gVar.M = false;
                    ((CardView) gVar.A.f7867x).setVisibility(8);
                    gVar.H = -1;
                    gVar.I = 0L;
                    if (gVar.J) {
                        m4.q qVar = playerView.E;
                        if (qVar != null && (vVar = qVar.f8248v) != null) {
                            vVar.f();
                        }
                        playerView.g(playerView.f());
                    }
                    long j7 = j4;
                    if (j7 != -5) {
                        a7.a aVar = (a7.a) gVar.C;
                        aVar.getClass();
                        aVar.j1(((g0) aVar).Y(), j7, false);
                    }
                }
            }
        }, 1000L);
    }

    public final Rect b() {
        PlayerView playerView = this.B;
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
        throw new UnsupportedOperationException("Method not decompiled: q5.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
