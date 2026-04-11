package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9278a;

    public /* synthetic */ n2(int i) {
        this.f9278a = i;
    }

    public final Drawable a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        switch (this.f9278a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String classAttribute = attributeSet.getClassAttribute();
                if (classAttribute != null) {
                    try {
                        Drawable drawable = (Drawable) n2.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                        k.a.c(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
                    } catch (Exception e9) {
                        Log.e("DrawableDelegate", "Exception while inflating <drawable>", e9);
                        return null;
                    }
                }
                break;
            case 1:
                try {
                } catch (Exception e10) {
                    Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                    return null;
                }
                break;
            case 2:
                try {
                    Resources resources = context.getResources();
                    m5.d dVar = new m5.d(context, 0);
                    dVar.inflate(resources, xmlResourceParser, attributeSet, theme);
                } catch (Exception e11) {
                    Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e11);
                    return null;
                }
                break;
            default:
                try {
                    Resources resources2 = context.getResources();
                    m5.o oVar = new m5.o();
                    oVar.inflate(resources2, xmlResourceParser, attributeSet, theme);
                } catch (Exception e12) {
                    Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e12);
                    return null;
                }
                break;
        }
        return null;
    }
}
