package w2;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatButton;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.ref.ReferenceQueue;
import java.util.WeakHashMap;
import o.t1;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13880v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f13881w;

    public /* synthetic */ m(int i, Object obj) {
        this.f13880v = i;
        this.f13881w = obj;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f13880v;
        Object obj = this.f13881w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((l) obj).f();
                return;
            case 1:
                x0.d dVar = (x0.d) obj;
                t1 t1Var = dVar.f14216x;
                x0.a aVar = dVar.f14214v;
                if (dVar.J) {
                    if (dVar.H) {
                        dVar.H = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar.f14211e = jCurrentAnimationTimeMillis;
                        aVar.f14212g = -1L;
                        aVar.f = jCurrentAnimationTimeMillis;
                        aVar.f14213h = 0.5f;
                    }
                    if ((aVar.f14212g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar.f14212g + ((long) aVar.i)) || !dVar.e()) {
                        dVar.J = false;
                        return;
                    }
                    if (dVar.I) {
                        dVar.I = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        t1Var.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (aVar.f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = aVar.a(jCurrentAnimationTimeMillis2);
                    long j4 = jCurrentAnimationTimeMillis2 - aVar.f;
                    aVar.f = jCurrentAnimationTimeMillis2;
                    dVar.L.scrollListBy((int) (j4 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * aVar.f14210d));
                    WeakHashMap weakHashMap = m0.f11777a;
                    t1Var.postOnAnimation(this);
                    return;
                }
                return;
            case 2:
                x5.b bVar = (x5.b) obj;
                int i10 = bVar.f14335x0;
                if (i10 <= 0) {
                    ((AppCompatButton) bVar.f14330s0.f1802y).setText("X");
                    ((AppCompatButton) bVar.f14330s0.f1802y).setEnabled(true);
                    return;
                } else {
                    ((AppCompatButton) bVar.f14330s0.f1802y).setText(String.valueOf(i10));
                    bVar.f14335x0--;
                    bVar.f14334w0.postDelayed(this, 1000L);
                    return;
                }
            default:
                l7.a aVar2 = (l7.a) obj;
                aVar2.getClass();
                while (true) {
                    try {
                        aVar2.n((z6.a) ((ReferenceQueue) aVar2.f7867x).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                break;
        }
    }
}
