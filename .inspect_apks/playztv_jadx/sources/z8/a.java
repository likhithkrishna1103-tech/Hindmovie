package z8;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import q4.f0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f14899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14900b;

    public a() {
        Paint paint = new Paint();
        this.f14899a = paint;
        this.f14900b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // q4.f0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        float dimension = recyclerView.getResources().getDimension(p8.d.m3_carousel_debug_keyline_width);
        Paint paint = this.f14899a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.f14900b.iterator();
        while (it.hasNext()) {
            ((c) it.next()).getClass();
            ThreadLocal threadLocal = i0.b.f6159a;
            float f = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).E0()) {
                canvas2 = canvas;
                canvas2.drawLine(0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3376q.g(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3376q.c(), paint);
            } else {
                canvas2 = canvas;
                canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f3376q.d(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3376q.e(), 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
