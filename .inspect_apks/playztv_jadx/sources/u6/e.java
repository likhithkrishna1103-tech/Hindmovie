package u6;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import c0.f;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Integer f12790d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f12791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12792b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f12793c;

    public e(ImageView imageView) {
        this.f12791a = imageView;
    }

    public final int a(int i, int i10, int i11) {
        int i12 = i10 - i11;
        if (i12 > 0) {
            return i12;
        }
        int i13 = i - i11;
        if (i13 > 0) {
            return i13;
        }
        View view = this.f12791a;
        if (view.isLayoutRequested() || i10 != -2) {
            return 0;
        }
        if (Log.isLoggable("ViewTarget", 4)) {
            Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = view.getContext();
        if (f12790d == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            x6.f.c(windowManager, "Argument must not be null");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f12790d = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f12790d.intValue();
    }
}
