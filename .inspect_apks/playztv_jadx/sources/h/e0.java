package h;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f5485u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f5486v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Method f5487w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Context f5488x;

    public e0(View view, String str) {
        this.f5485u = view;
        this.f5486v = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f5487w == null) {
            View view2 = this.f5485u;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f5486v;
                if (context == null) {
                    int id2 = view2.getId();
                    if (id2 == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id2) + "'";
                    }
                    throw new IllegalStateException("Could not find method " + str2 + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + view2.getClass() + str);
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f5487w = method;
                        this.f5488x = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f5487w.invoke(this.f5488x, view);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
        } catch (InvocationTargetException e11) {
            throw new IllegalStateException("Could not execute method for android:onClick", e11);
        }
    }
}
