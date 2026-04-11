package d0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f3117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3119e;

    public g(Context context, XmlResourceParser xmlResourceParser) {
        this.f3115a = Float.NaN;
        this.f3116b = Float.NaN;
        this.f3117c = Float.NaN;
        this.f3118d = Float.NaN;
        this.f3119e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.Variant);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == r.Variant_constraints) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f3119e);
                this.f3119e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new n().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == r.Variant_region_heightLessThan) {
                this.f3118d = typedArrayObtainStyledAttributes.getDimension(index, this.f3118d);
            } else if (index == r.Variant_region_heightMoreThan) {
                this.f3116b = typedArrayObtainStyledAttributes.getDimension(index, this.f3116b);
            } else if (index == r.Variant_region_widthLessThan) {
                this.f3117c = typedArrayObtainStyledAttributes.getDimension(index, this.f3117c);
            } else if (index == r.Variant_region_widthMoreThan) {
                this.f3115a = typedArrayObtainStyledAttributes.getDimension(index, this.f3115a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
