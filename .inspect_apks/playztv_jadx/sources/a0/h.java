package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f62a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f63b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f64c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f65d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f66e;

    public h(Context context, XmlResourceParser xmlResourceParser) {
        this.f62a = Float.NaN;
        this.f63b = Float.NaN;
        this.f64c = Float.NaN;
        this.f65d = Float.NaN;
        this.f66e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), s.Variant);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == s.Variant_constraints) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f66e);
                this.f66e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new o().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == s.Variant_region_heightLessThan) {
                this.f65d = typedArrayObtainStyledAttributes.getDimension(index, this.f65d);
            } else if (index == s.Variant_region_heightMoreThan) {
                this.f63b = typedArrayObtainStyledAttributes.getDimension(index, this.f63b);
            } else if (index == s.Variant_region_widthLessThan) {
                this.f64c = typedArrayObtainStyledAttributes.getDimension(index, this.f64c);
            } else if (index == s.Variant_region_widthMoreThan) {
                this.f62a = typedArrayObtainStyledAttributes.getDimension(index, this.f62a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
