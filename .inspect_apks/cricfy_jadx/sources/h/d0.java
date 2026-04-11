package h;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f5311v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f5312w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Method f5313x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Context f5314y;

    public d0(View view, String str) {
        this.f5311v = view;
        this.f5312w = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f5313x == null) {
            View view2 = this.f5311v;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f5312w;
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
                        this.f5313x = method;
                        this.f5314y = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f5313x.invoke(this.f5314y, view);
        } catch (IllegalAccessException e9) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e9);
        } catch (InvocationTargetException e10) {
            throw new IllegalStateException("Could not execute method for android:onClick", e10);
        }
    }
}
