package vf;

import ag.w;
import ag.y;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import j9.p;
import j9.q;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import l4.c0;
import o8.u;
import t0.l0;
import t0.m0;
import y1.a0;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f13733a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f13734b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f13735c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f13736d;

    public g() {
        new ConcurrentHashMap();
    }

    public static p A(Object obj) {
        p pVar = new p();
        pVar.l(obj);
        return pVar;
    }

    public static final String B(long j4) {
        return String.format("%6s", Arrays.copyOf(new Object[]{j4 <= -999500000 ? q4.a.p(new StringBuilder(), (j4 - ((long) 500000000)) / ((long) 1000000000), " s ") : j4 <= -999500 ? q4.a.p(new StringBuilder(), (j4 - ((long) 500000)) / ((long) 1000000), " ms") : j4 <= 0 ? q4.a.p(new StringBuilder(), (j4 - ((long) 500)) / ((long) 1000), " µs") : j4 < 999500 ? q4.a.p(new StringBuilder(), (j4 + ((long) 500)) / ((long) 1000), " µs") : j4 < 999500000 ? q4.a.p(new StringBuilder(), (j4 + ((long) 500000)) / ((long) 1000000), " ms") : q4.a.p(new StringBuilder(), (j4 + ((long) 500000000)) / ((long) 1000000000), " s ")}, 1));
    }

    public static hb.b C(String str, a3.m mVar) {
        hb.a aVarB = hb.b.b(pc.a.class);
        aVarB.f5872c = 1;
        aVarB.a(hb.j.b(Context.class));
        aVarB.f5875g = new androidx.fragment.app.e(16, str, mVar);
        return aVarB.b();
    }

    public static String G(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String strConcat = "TRuntime.".concat(str);
        return strConcat.length() > 23 ? strConcat.substring(0, 23) : strConcat;
    }

    public static void X(final Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z10, v5.b bVar, d8.f fVar) {
        h.g gVar = new h.g(context);
        View viewInflate = LayoutInflater.from(context).inflate(q5.l.dialog_add_playlist, (ViewGroup) null, false);
        int i = q5.k.login_ly;
        LinearLayout linearLayout = (LinearLayout) android.support.v4.media.session.b.l(viewInflate, i);
        if (linearLayout != null) {
            i = q5.k.pass_container;
            TextInputLayout textInputLayout = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
            if (textInputLayout != null) {
                i = q5.k.password_input;
                TextInputEditText textInputEditText = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                if (textInputEditText != null) {
                    i = q5.k.path_input;
                    TextInputEditText textInputEditText2 = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                    if (textInputEditText2 != null) {
                        i = q5.k.path_input_container;
                        TextInputLayout textInputLayout2 = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                        if (textInputLayout2 != null) {
                            i = q5.k.title_container;
                            TextInputLayout textInputLayout3 = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                            if (textInputLayout3 != null) {
                                i = q5.k.title_input;
                                TextInputEditText textInputEditText3 = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                                if (textInputEditText3 != null) {
                                    i = q5.k.user_container;
                                    TextInputLayout textInputLayout4 = (TextInputLayout) android.support.v4.media.session.b.l(viewInflate, i);
                                    if (textInputLayout4 != null) {
                                        i = q5.k.username_input;
                                        TextInputEditText textInputEditText4 = (TextInputEditText) android.support.v4.media.session.b.l(viewInflate, i);
                                        if (textInputEditText4 != null) {
                                            ScrollView scrollView = (ScrollView) viewInflate;
                                            final dd.c cVar = new dd.c(scrollView, linearLayout, textInputLayout, textInputEditText, textInputEditText2, textInputLayout2, textInputLayout3, textInputEditText3, textInputLayout4, textInputEditText4);
                                            if (str3 != null) {
                                                textInputEditText3.setText(str3);
                                                textInputEditText2.setText(str4);
                                                textInputEditText4.setText(str5);
                                                textInputEditText.setText(str6);
                                            }
                                            if (z10) {
                                                textInputLayout2.setHint("Enter Server:Port");
                                                linearLayout.setVisibility(0);
                                            }
                                            gVar.setView(scrollView);
                                            gVar.setTitle(str);
                                            gVar.c(str2, null);
                                            gVar.b("Cancel");
                                            if (fVar != null) {
                                                a6.c cVar2 = new a6.c(4, fVar);
                                                h.c cVar3 = gVar.f5346a;
                                                cVar3.f5298k = "Delete";
                                                cVar3.f5299l = cVar2;
                                            }
                                            h.h hVarD = gVar.d();
                                            hVarD.B.i.setOnClickListener(new d6.b(cVar, hVarD, bVar, 4));
                                            final int i10 = 0;
                                            textInputLayout3.setEndIconOnClickListener(new View.OnClickListener() { // from class: v5.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i10) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f3675z).setText(j4.r(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f3674y).setText(j4.r(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.A).setText(j4.r(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f3673x).setText(j4.r(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i11 = 1;
                                            textInputLayout2.setEndIconOnClickListener(new View.OnClickListener() { // from class: v5.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i11) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f3675z).setText(j4.r(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f3674y).setText(j4.r(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.A).setText(j4.r(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f3673x).setText(j4.r(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i12 = 2;
                                            textInputLayout4.setEndIconOnClickListener(new View.OnClickListener() { // from class: v5.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i12) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f3675z).setText(j4.r(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f3674y).setText(j4.r(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.A).setText(j4.r(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f3673x).setText(j4.r(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i13 = 3;
                                            textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: v5.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i13) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f3675z).setText(j4.r(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f3674y).setText(j4.r(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.A).setText(j4.r(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f3673x).setText(j4.r(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final ag.l Y(InputStream inputStream) {
        ge.i.e(inputStream, "<this>");
        return new ag.l(inputStream, new y());
    }

    public static final void a(Logger logger, nf.a aVar, nf.c cVar, String str) {
        logger.fine(cVar.f9154b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + aVar.f9148a);
    }

    public static String a0(int i) {
        Object[] objArr = {Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(((double) Color.alpha(i)) / 255.0d)};
        int i10 = a0.f14551a;
        return String.format(Locale.US, "rgba(%d,%d,%d,%.3f)", objArr);
    }

    public static Object b(p pVar) throws InterruptedException {
        u.f("Must not be called on the main application thread");
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && Objects.equals(looperMyLooper.getThread().getName(), "GoogleApiHandler")) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        u.h(pVar, "Task must not be null");
        if (pVar.i()) {
            return d0(pVar);
        }
        j9.k kVar = new j9.k(0);
        Executor executor = j9.j.f6690b;
        pVar.d(executor, kVar);
        pVar.c(executor, kVar);
        pVar.a(executor, kVar);
        kVar.f6692w.await();
        return d0(pVar);
    }

    public static p b0(List list) {
        if (list == null || list.isEmpty()) {
            return A(null);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((p) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        p pVar = new p();
        j9.l lVar = new j9.l(list.size(), pVar);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            p pVar2 = (p) it2.next();
            eb.d dVar = j9.j.f6690b;
            pVar2.d(dVar, lVar);
            pVar2.c(dVar, lVar);
            pVar2.a(dVar, lVar);
        }
        return pVar;
    }

    public static Object c(p pVar, long j4, TimeUnit timeUnit) throws TimeoutException {
        u.f("Must not be called on the main application thread");
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && Objects.equals(looperMyLooper.getThread().getName(), "GoogleApiHandler")) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        u.h(pVar, "Task must not be null");
        u.h(timeUnit, "TimeUnit must not be null");
        if (pVar.i()) {
            return d0(pVar);
        }
        j9.k kVar = new j9.k(0);
        Executor executor = j9.j.f6690b;
        pVar.d(executor, kVar);
        pVar.c(executor, kVar);
        pVar.a(executor, kVar);
        if (kVar.f6692w.await(j4, timeUnit)) {
            return d0(pVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static p c0(p... pVarArr) {
        if (pVarArr.length == 0) {
            return A(Collections.EMPTY_LIST);
        }
        List listAsList = Arrays.asList(pVarArr);
        return (listAsList == null || listAsList.isEmpty()) ? A(Collections.EMPTY_LIST) : b0(listAsList).f(j9.j.f6689a, new q(listAsList));
    }

    public static final ag.q d(w wVar) {
        ge.i.e(wVar, "<this>");
        return new ag.q(wVar);
    }

    public static Object d0(p pVar) throws ExecutionException {
        if (pVar.j()) {
            return pVar.h();
        }
        if (pVar.f6709d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(pVar.g());
    }

    public static p e(Executor executor, Callable callable) {
        u.h(executor, "Executor must not be null");
        p pVar = new p();
        executor.execute(new s(28, pVar, callable));
        return pVar;
    }

    public static hb.b n(String str, String str2) {
        pc.a aVar = new pc.a(str, str2);
        hb.a aVarB = hb.b.b(pc.a.class);
        aVarB.f5872c = 1;
        aVarB.f5875g = new h2.d(aVar);
        return aVarB.b();
    }

    public static void t(String str, String str2, Object obj) {
        String strG = G(str);
        if (Log.isLoggable(strG, 3)) {
            Log.d(strG, String.format(str2, obj));
        }
    }

    public static boolean u(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = m0.f11777a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = l0.f11772d;
        l0 l0Var = (l0) view.getTag(g0.c.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (l0Var == null) {
            l0Var = new l0();
            l0Var.f11773a = null;
            l0Var.f11774b = null;
            l0Var.f11775c = null;
            view.setTag(g0.c.tag_unhandled_key_event_manager, l0Var);
        }
        WeakReference weakReference2 = l0Var.f11775c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        l0Var.f11775c = new WeakReference(keyEvent);
        if (l0Var.f11774b == null) {
            l0Var.f11774b = new SparseArray();
        }
        SparseArray sparseArray = l0Var.f11774b;
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(g0.c.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        throw q4.a.k(size, arrayList);
    }

    public static boolean v(t0.j jVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (jVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return jVar.b(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!f13733a) {
                            try {
                                f13734b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            f13733a = true;
                        }
                        Method method = f13734b;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (m0.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!f13735c) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        f13736d = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    f13735c = true;
                }
                Field field = f13736d;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (m0.c(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && m0.c(view, keyEvent)) || jVar.b(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static void x(String str, String str2, Exception exc) {
        String strG = G(str);
        if (Log.isLoggable(strG, 6)) {
            Log.e(strG, str2, exc);
        }
    }

    public static p z(Exception exc) {
        p pVar = new p();
        pVar.n(exc);
        return pVar;
    }

    public abstract ya.c D(ya.o oVar);

    public abstract ya.n E(ya.o oVar);

    public abstract int F();

    public abstract Context H();

    public boolean I() {
        return false;
    }

    public abstract void J();

    public abstract boolean L(int i, KeyEvent keyEvent);

    public boolean M(KeyEvent keyEvent) {
        return false;
    }

    public boolean N() {
        return false;
    }

    public abstract void O(x.g gVar, x.g gVar2);

    public abstract void P(ya.n nVar, ya.n nVar2);

    public abstract void Q(x.g gVar, Thread thread);

    public abstract void R(ya.n nVar, Thread thread);

    public abstract void S(boolean z10);

    public abstract void T(boolean z10);

    public abstract void U();

    public abstract void V(boolean z10);

    public abstract void W(CharSequence charSequence);

    public m.a Z(c0 c0Var) {
        return null;
    }

    public abstract boolean f(x.h hVar, x.d dVar, x.d dVar2);

    public abstract boolean g(ya.o oVar, ya.c cVar, ya.c cVar2);

    public abstract boolean h(x.h hVar, Object obj, Object obj2);

    public abstract boolean i(ya.o oVar, Object obj, Object obj2);

    public abstract boolean j(x.h hVar, x.g gVar, x.g gVar2);

    public abstract boolean k(ya.o oVar, ya.n nVar, ya.n nVar2);

    public boolean l() {
        return false;
    }

    public abstract boolean m();

    public abstract Typeface o(Context context, k0.e eVar, Resources resources, int i);

    public abstract Typeface p(Context context, q0.i[] iVarArr, int i);

    public Typeface q(Context context, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface r(Context context, InputStream inputStream) {
        File fileJ = w1.d.j(context);
        if (fileJ == null) {
            return null;
        }
        try {
            if (w1.d.d(fileJ, inputStream)) {
                return Typeface.createFromFile(fileJ.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileJ.delete();
        }
    }

    public Typeface s(Context context, Resources resources, int i, String str, int i10) {
        File fileJ = w1.d.j(context);
        if (fileJ == null) {
            return null;
        }
        try {
            if (w1.d.c(fileJ, resources, i)) {
                return Typeface.createFromFile(fileJ.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileJ.delete();
        }
    }

    public abstract void w(boolean z10);

    public q0.i y(q0.i[] iVarArr, int i) {
        new f9.a0(15);
        int i10 = (i & 1) == 0 ? 400 : 700;
        boolean z10 = (i & 2) != 0;
        q0.i iVar = null;
        int i11 = Integer.MAX_VALUE;
        for (q0.i iVar2 : iVarArr) {
            int iAbs = (Math.abs(iVar2.f10346c - i10) * 2) + (iVar2.f10347d == z10 ? 0 : 1);
            if (iVar == null || i11 > iAbs) {
                iVar = iVar2;
                i11 = iAbs;
            }
        }
        return iVar;
    }

    public void K() {
    }
}
