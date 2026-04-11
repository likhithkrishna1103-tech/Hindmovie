package h;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import java.lang.reflect.Constructor;
import n.d1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class[] f5491b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f5492c = {R.attr.onClick};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f5493d = {R.attr.accessibilityHeading};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f5494e = {R.attr.accessibilityPaneTitle};
    public static final int[] f = {R.attr.screenReaderFocusable};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f5495g = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final s.i f5496h = new s.i(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f5497a = new Object[2];

    public n.o a(Context context, AttributeSet attributeSet) {
        return new n.o(context, attributeSet, g.a.autoCompleteTextViewStyle);
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public n.q c(Context context, AttributeSet attributeSet) {
        return new n.q(context, attributeSet, g.a.checkboxStyle);
    }

    public n.c0 d(Context context, AttributeSet attributeSet) {
        return new n.c0(context, attributeSet, g.a.radioButtonStyle);
    }

    public d1 e(Context context, AttributeSet attributeSet) {
        return new d1(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String strConcat;
        s.i iVar = f5496h;
        Constructor constructor = (Constructor) iVar.get(str);
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
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f5491b);
            iVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f5497a);
    }
}
