package b5;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.j4;
import g.j;
import ge.i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import o.n1;
import o.q;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Parcelable f1789e;
    public Object f;

    public /* synthetic */ e(TextView textView) {
        this.f1789e = null;
        this.f = null;
        this.f1785a = false;
        this.f1786b = false;
        this.f1788d = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f1788d;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f1785a || this.f1786b) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.f1785a) {
                    drawableMutate.setTintList((ColorStateList) this.f1789e);
                }
                if (this.f1786b) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.f);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void b() {
        q qVar = (q) this.f1788d;
        Drawable checkMarkDrawable = qVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f1785a || this.f1786b) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f1785a) {
                    drawableMutate.setTintList((ColorStateList) this.f1789e);
                }
                if (this.f1786b) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.f);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(qVar.getDrawableState());
                }
                qVar.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public Bundle c(String str) {
        if (!this.f1786b) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = (Bundle) this.f1789e;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.f1789e;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.f1789e;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f1789e = null;
        return bundle2;
    }

    public d d() {
        String str;
        d dVar;
        Iterator it = ((q.f) this.f1788d).iterator();
        do {
            q.b bVar = (q.b) it;
            if (!bVar.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) bVar.next();
            i.d(entry, "components");
            str = (String) entry.getKey();
            dVar = (d) entry.getValue();
        } while (!i.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return dVar;
    }

    public void e(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f1788d;
        l7.a aVarF = l7.a.F(compoundButton.getContext(), attributeSet, j.CompoundButton, i);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        m0.m(compoundButton, compoundButton.getContext(), j.CompoundButton, attributeSet, (TypedArray) aVarF.f7867x, i);
        try {
            if (typedArray.hasValue(j.CompoundButton_buttonCompat) && (resourceId2 = typedArray.getResourceId(j.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(j4.i(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(j.CompoundButton_android_button)) {
                        compoundButton.setButtonDrawable(j4.i(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(j.CompoundButton_android_button) && (resourceId = typedArray.getResourceId(j.CompoundButton_android_button, 0)) != 0) {
                compoundButton.setButtonDrawable(j4.i(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(j.CompoundButton_buttonTint)) {
                compoundButton.setButtonTintList(aVarF.r(j.CompoundButton_buttonTint));
            }
            if (typedArray.hasValue(j.CompoundButton_buttonTintMode)) {
                compoundButton.setButtonTintMode(n1.c(typedArray.getInt(j.CompoundButton_buttonTintMode, -1), null));
            }
            aVarF.G();
        } catch (Throwable th) {
            aVarF.G();
            throw th;
        }
    }

    public void f(String str, d dVar) {
        Object obj;
        i.e(dVar, "provider");
        q.f fVar = (q.f) this.f1788d;
        q.c cVarA = fVar.a(str);
        if (cVarA != null) {
            obj = cVarA.f10311w;
        } else {
            q.c cVar = new q.c(str, dVar);
            fVar.f10320y++;
            q.c cVar2 = fVar.f10318w;
            if (cVar2 == null) {
                fVar.f10317v = cVar;
                fVar.f10318w = cVar;
            } else {
                cVar2.f10312x = cVar;
                cVar.f10313y = cVar2;
                fVar.f10318w = cVar;
            }
            obj = null;
        }
        if (((d) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void g() {
        if (!this.f1787c) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        b bVar = (b) this.f;
        if (bVar == null) {
            bVar = new b(this);
        }
        this.f = bVar;
        try {
            androidx.lifecycle.j.class.getDeclaredConstructor(null);
            b bVar2 = (b) this.f;
            if (bVar2 != null) {
                ((LinkedHashSet) bVar2.f1784b).add(androidx.lifecycle.j.class.getName());
            }
        } catch (NoSuchMethodException e9) {
            throw new IllegalArgumentException("Class " + androidx.lifecycle.j.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e9);
        }
    }

    public e() {
        this.f1788d = new q.f();
        this.f1787c = true;
    }
}
