package i5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputFilter;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.versionedparcelable.ParcelImpl;
import be.h;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import ke.f0;
import ke.i1;
import ke.x;
import q0.o0;
import q9.f;
import q9.g;
import q9.i;
import re.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f6359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f6361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f6362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Field f6363e;
    public static boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Field f6364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f6365h;
    public static Boolean i;

    public a() {
        new ConcurrentHashMap();
    }

    public static d A(Bundle bundle) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable("android.support.v4.media.session.SESSION_TOKEN2");
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(a.class.getClassLoader());
            Parcelable parcelable = bundle2.getParcelable("a");
            if (parcelable instanceof ParcelImpl) {
                return ((ParcelImpl) parcelable).f1704u;
            }
            throw new IllegalArgumentException("Invalid parcel");
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static boolean C(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static void F(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static b1.c G(String str, rc.b bVar) {
        e eVar = f0.f7690a;
        re.d dVar = re.d.f11591w;
        i1 i1Var = new i1(null);
        dVar.getClass();
        pe.c cVarA = x.a(q1.c.H(dVar, i1Var));
        h.e(str, "name");
        return new b1.c(str, bVar, b1.a.f1710v, cVarA);
    }

    public static void H(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static final void I(Object[] objArr, int i10, int i11) {
        h.e(objArr, "<this>");
        while (i10 < i11) {
            objArr[i10] = null;
            i10++;
        }
    }

    public static void K(ViewGroup viewGroup, float f4) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof g) {
            ((g) background).k(f4);
        }
    }

    public static void M(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = o0.f10475a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z2 = onLongClickListener != null;
        boolean z10 = zHasOnClickListeners || z2;
        checkableImageButton.setFocusable(z10);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        checkableImageButton.setImportantForAccessibility(z10 ? 1 : 2);
    }

    public static void N(View view, g gVar) {
        f9.a aVar = gVar.f11105u.f11091b;
        if (aVar == null || !aVar.f4811a) {
            return;
        }
        float fE = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = o0.f10475a;
            fE += q0.f0.e((View) parent);
        }
        f fVar = gVar.f11105u;
        if (fVar.f11099l != fE) {
            fVar.f11099l = fE;
            gVar.q();
        }
    }

    public static void O(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof g) {
            N(viewGroup, (g) background);
        }
    }

    public static final void Q(Object obj) throws Throwable {
        if (obj instanceof nd.g) {
            throw ((nd.g) obj).f8985u;
        }
    }

    public static final String a(Object[] objArr, int i10, int i11, od.d dVar) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            Object obj = objArr[i10 + i12];
            if (obj == dVar) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(obj);
            }
        }
        sb2.append("]");
        String string = sb2.toString();
        h.d(string, "toString(...)");
        return string;
    }

    public static void b(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static final void e(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                com.bumptech.glide.d.d(th, th2);
            }
        }
    }

    public static ImageView.ScaleType f(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 5 ? i10 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static ga.b g(int i10) {
        return i10 != 0 ? i10 != 1 ? new i() : new q9.d() : new i();
    }

    public static final nd.g h(Throwable th) {
        h.e(th, "exception");
        return new nd.g(th);
    }

    public static boolean n(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display != null && display.isHdr()) {
            for (int i10 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i10 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean o(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void q(Object obj) {
        LongSparseArray longSparseArray;
        if (!f6362d) {
            try {
                f6361c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e10) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e10);
            }
            f6362d = true;
        }
        Class cls = f6361c;
        if (cls == null) {
            return;
        }
        if (!f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f6363e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e11);
            }
            f = true;
        }
        Field field = f6363e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e12) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e12);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public abstract boolean B(float f4);

    public abstract boolean D(View view);

    public abstract boolean E(float f4, float f10);

    public abstract void J(boolean z2);

    public abstract void L(boolean z2);

    public abstract boolean P(View view, float f4);

    public abstract void R(ViewGroup.MarginLayoutParams marginLayoutParams, int i10);

    public abstract void S(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11);

    public abstract int c(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float d(int i10);

    public abstract Typeface i(Context context, h0.e eVar, Resources resources, int i10);

    public abstract Typeface j(Context context, n0.i[] iVarArr, int i10);

    public Typeface k(Context context, List list, int i10) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface l(Context context, InputStream inputStream) {
        File fileD = q1.c.D(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (q1.c.r(fileD, inputStream)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    public Typeface m(Context context, Resources resources, int i10, String str, int i11) {
        File fileD = q1.c.D(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (q1.c.q(fileD, resources, i10)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    public n0.i p(n0.i[] iVarArr, int i10) {
        new pa.b(14);
        int i11 = (i10 & 1) == 0 ? 400 : 700;
        boolean z2 = (i10 & 2) != 0;
        n0.i iVar = null;
        int i12 = Integer.MAX_VALUE;
        for (n0.i iVar2 : iVarArr) {
            int iAbs = (Math.abs(iVar2.f8631c - i11) * 2) + (iVar2.f8632d == z2 ? 0 : 1);
            if (iVar == null || i12 > iAbs) {
                iVar = iVar2;
                i12 = iAbs;
            }
        }
        return iVar;
    }

    public abstract int r(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int s();

    public abstract InputFilter[] t(InputFilter[] inputFilterArr);

    public abstract int u();

    public abstract int v();

    public abstract int w();

    public abstract int x(View view);

    public abstract int y(CoordinatorLayout coordinatorLayout);

    public abstract int z();
}
