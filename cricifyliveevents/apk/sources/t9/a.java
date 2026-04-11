package t9;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k9.d;
import v4.f0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f11951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11952b;

    public a() {
        Paint paint = new Paint();
        this.f11951a = paint;
        this.f11952b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // v4.f0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        float dimension = recyclerView.getResources().getDimension(d.m3_carousel_debug_keyline_width);
        Paint paint = this.f11951a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.f11952b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).getClass();
            ThreadLocal threadLocal = l0.b.f7600a;
            float f = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).F0()) {
                canvas2 = canvas;
                canvas2.drawLine(0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2835q.g(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2835q.c(), paint);
            } else {
                canvas2 = canvas;
                canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f2835q.d(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2835q.e(), 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
