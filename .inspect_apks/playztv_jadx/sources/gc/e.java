package gc;

import a2.o0;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.media3.ui.PlayerView;
import i4.s;
import i4.x;
import java.util.Formatter;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5379u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MotionEvent f5380v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g f5381w;

    public e(g gVar) {
        this.f5381w = gVar;
    }

    public final boolean a(MotionEvent motionEvent, double d10) {
        g gVar = this.f5381w;
        return motionEvent.getY() <= ((float) (gVar.b().height() * 150)) / ((float) gVar.f5388x) && d10 > 0.0d;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        s sVar;
        x xVar;
        int i;
        if (motionEvent == null) {
            return false;
        }
        float x10 = motionEvent.getX();
        g gVar = this.f5381w;
        boolean z2 = x10 > ((float) (gVar.f5387w / 2));
        Formatter formatter = gVar.D;
        StringBuilder sb2 = gVar.C;
        kc.b bVar = gVar.f5390z;
        if (gVar.J || gVar.B == null) {
            return true;
        }
        gVar.L = true;
        if (gVar.I && (sVar = gVar.A.D) != null && (i = (xVar = sVar.f6278u).f6348z) != 3 && i != 2) {
            xVar.f();
            xVar.i(2);
        }
        if (z2 && ((o0) gVar.B).I() != 4 && ((c3.e) gVar.B).e0(12)) {
            gVar.H += 10;
            gVar.G++;
            long jT0 = ((o0) gVar.B).T0();
            long duration = ((o0) gVar.B).getDuration();
            long j5 = gVar.H * 1000;
            long j8 = j5 + jT0;
            if (j8 > duration) {
                j5 = duration - jT0;
            } else {
                duration = j8;
            }
            ((ImageView) bVar.f7620v).setImageResource(i.ic_forward);
            ((TextView) bVar.f7622x).setText("+" + b0.C(sb2, formatter, j5));
            gVar.a(duration);
            ((CardView) bVar.f7621w).setVisibility(0);
            return true;
        }
        if (!((c3.e) gVar.B).e0(11)) {
            if (z2) {
                ((TextView) bVar.f7622x).setText("+00:00");
                ((ImageView) bVar.f7620v).setImageResource(i.ic_forward);
            } else {
                ((TextView) bVar.f7622x).setText("-00:00");
                ((ImageView) bVar.f7620v).setImageResource(i.ic_rewind);
            }
            gVar.a(-5L);
            ((CardView) bVar.f7621w).setVisibility(0);
            return true;
        }
        gVar.H += 10;
        gVar.G++;
        long jT02 = ((o0) gVar.B).T0();
        long j10 = gVar.H * 1000;
        long j11 = jT02 - j10;
        if (j11 < 0) {
            j11 = 0;
        } else {
            jT02 = j10;
        }
        ((TextView) bVar.f7622x).setText("-" + b0.C(sb2, formatter, jT02));
        ((ImageView) bVar.f7620v).setImageResource(i.ic_rewind);
        gVar.a(j11);
        ((CardView) bVar.f7621w).setVisibility(0);
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
        throw new UnsupportedOperationException("Method not decompiled: gc.e.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        x xVar;
        x xVar2;
        int i;
        g gVar = this.f5381w;
        PlayerView playerView = gVar.A;
        boolean zC = playerView.c();
        s sVar = playerView.D;
        if (!zC || gVar.K || gVar.L) {
            if (gVar.I) {
                return true;
            }
            if (sVar != null && (xVar = sVar.f6278u) != null) {
                xVar.f();
            }
            playerView.h(playerView.g());
            return true;
        }
        if (!gVar.J) {
            playerView.b();
            return true;
        }
        if (sVar == null || (i = (xVar2 = sVar.f6278u).f6348z) == 3 || i == 2) {
            return true;
        }
        xVar2.f();
        xVar2.i(2);
        return true;
    }
}
