package q5;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.media3.ui.PlayerView;
import g2.g0;
import java.util.Formatter;
import m4.v;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10374v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MotionEvent f10375w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ g f10376x;

    public e(g gVar) {
        this.f10376x = gVar;
    }

    public final boolean a(MotionEvent motionEvent, double d10) {
        g gVar = this.f10376x;
        return motionEvent.getY() <= ((float) (gVar.b().height() * 150)) / ((float) gVar.f10383y) && d10 > 0.0d;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        m4.q qVar;
        v vVar;
        int i;
        if (motionEvent == null) {
            return false;
        }
        float x10 = motionEvent.getX();
        g gVar = this.f10376x;
        boolean z10 = x10 > ((float) (gVar.f10382x / 2));
        Formatter formatter = gVar.E;
        StringBuilder sb = gVar.D;
        l7.a aVar = gVar.A;
        if (gVar.K || gVar.C == null) {
            return true;
        }
        gVar.M = true;
        if (gVar.J && (qVar = gVar.B.E) != null && (i = (vVar = qVar.f8248v).f8292z) != 3 && i != 2) {
            vVar.f();
            vVar.i(2);
        }
        if (z10 && ((g0) gVar.C).E() != 4 && ((a7.a) gVar.C).Z(12)) {
            gVar.I += 10;
            gVar.H++;
            long jV0 = ((g0) gVar.C).V0();
            long duration = ((g0) gVar.C).getDuration();
            long j4 = gVar.I * 1000;
            long j7 = j4 + jV0;
            if (j7 > duration) {
                j4 = duration - jV0;
            } else {
                duration = j7;
            }
            ((ImageView) aVar.f7866w).setImageResource(j.ic_forward);
            ((TextView) aVar.f7868y).setText("+" + a0.C(sb, formatter, j4));
            gVar.a(duration);
            ((CardView) aVar.f7867x).setVisibility(0);
            return true;
        }
        if (!((a7.a) gVar.C).Z(11)) {
            if (z10) {
                ((TextView) aVar.f7868y).setText("+00:00");
                ((ImageView) aVar.f7866w).setImageResource(j.ic_forward);
            } else {
                ((TextView) aVar.f7868y).setText("-00:00");
                ((ImageView) aVar.f7866w).setImageResource(j.ic_rewind);
            }
            gVar.a(-5L);
            ((CardView) aVar.f7867x).setVisibility(0);
            return true;
        }
        gVar.I += 10;
        gVar.H++;
        long jV02 = ((g0) gVar.C).V0();
        long j10 = gVar.I * 1000;
        long j11 = jV02 - j10;
        if (j11 < 0) {
            j11 = 0;
        } else {
            jV02 = j10;
        }
        ((TextView) aVar.f7868y).setText("-" + a0.C(sb, formatter, jV02));
        ((ImageView) aVar.f7866w).setImageResource(j.ic_rewind);
        gVar.a(j11);
        ((CardView) aVar.f7867x).setVisibility(0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onScroll(android.view.MotionEvent r22, android.view.MotionEvent r23, float r24, float r25) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.e.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        v vVar;
        v vVar2;
        int i;
        g gVar = this.f10376x;
        PlayerView playerView = gVar.B;
        m4.q qVar = playerView.E;
        m4.q qVar2 = playerView.E;
        if (qVar == null || !qVar.h() || gVar.L || gVar.M) {
            if (gVar.J) {
                return true;
            }
            if (qVar2 != null && (vVar = qVar2.f8248v) != null) {
                vVar.f();
            }
            playerView.g(playerView.f());
            return true;
        }
        if (!gVar.K) {
            playerView.b();
            return true;
        }
        if (qVar2 == null || (i = (vVar2 = qVar2.f8248v).f8292z) == 3 || i == 2) {
            return true;
        }
        vVar2.f();
        vVar2.i(2);
        return true;
    }
}
