package n;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8442a;

    public /* synthetic */ m2(int i) {
        this.f8442a = i;
    }

    public final Drawable a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        switch (this.f8442a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String classAttribute = attributeSet.getClassAttribute();
                if (classAttribute != null) {
                    try {
                        Drawable drawable = (Drawable) m2.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                        k.a.c(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
                    } catch (Exception e10) {
                        Log.e("DrawableDelegate", "Exception while inflating <drawable>", e10);
                        return null;
                    }
                }
                break;
            case 1:
                try {
                } catch (Exception e11) {
                    Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e11);
                    return null;
                }
                break;
            case 2:
                try {
                    Resources resources = context.getResources();
                    h5.f fVar = new h5.f(context, 0);
                    fVar.inflate(resources, xmlResourceParser, attributeSet, theme);
                } catch (Exception e12) {
                    Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e12);
                    return null;
                }
                break;
            default:
                try {
                    Resources resources2 = context.getResources();
                    h5.r rVar = new h5.r();
                    rVar.inflate(resources2, xmlResourceParser, attributeSet, theme);
                } catch (Exception e13) {
                    Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e13);
                    return null;
                }
                break;
        }
        return null;
    }
}
