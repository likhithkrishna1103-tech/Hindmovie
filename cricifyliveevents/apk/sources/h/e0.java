package h;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import java.lang.reflect.Constructor;
import o.a1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class[] f5315b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f5316c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f5317d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f5318e = {R.attr.accessibilityPaneTitle};
    public static final int[] f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f5319g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v.k f5320h = new v.k(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f5321a = new Object[2];

    public o.o a(Context context, AttributeSet attributeSet) {
        return new o.o(context, attributeSet, g.a.autoCompleteTextViewStyle);
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public o.p c(Context context, AttributeSet attributeSet) {
        return new o.p(context, attributeSet, g.a.checkboxStyle);
    }

    public o.a0 d(Context context, AttributeSet attributeSet) {
        return new o.a0(context, attributeSet, g.a.radioButtonStyle);
    }

    public a1 e(Context context, AttributeSet attributeSet) {
        return new a1(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String strConcat;
        v.k kVar = f5320h;
        Constructor constructor = (Constructor) kVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f5315b);
            kVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f5321a);
    }
}
