package v9;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13356e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f13357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f13358h;
    public final com.google.android.material.datepicker.n i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f13359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final nc.c f13360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13363n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f13364o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AccessibilityManager f13365p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f13366q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f13367r;

    public j(m mVar) {
        super(mVar);
        this.i = new com.google.android.material.datepicker.n(13, this);
        this.f13359j = new a(this, 1);
        this.f13360k = new nc.c(19, this);
        this.f13364o = Long.MAX_VALUE;
        this.f = b8.h.x(mVar.getContext(), p8.b.motionDurationShort3, 67);
        this.f13356e = b8.h.x(mVar.getContext(), p8.b.motionDurationShort3, 50);
        this.f13357g = b8.h.y(mVar.getContext(), p8.b.motionEasingLinearInterpolator, q8.a.f11072a);
    }

    @Override // v9.n
    public final void a() {
        if (this.f13365p.isTouchExplorationEnabled() && this.f13358h.getInputType() != 0 && !this.f13379d.hasFocus()) {
            this.f13358h.dismissDropDown();
        }
        this.f13358h.post(new nc.b(12, this));
    }

    @Override // v9.n
    public final int c() {
        return p8.j.exposed_dropdown_menu_content_description;
    }

    @Override // v9.n
    public final int d() {
        return p8.e.mtrl_dropdown_arrow;
    }

    @Override // v9.n
    public final View.OnFocusChangeListener e() {
        return this.f13359j;
    }

    @Override // v9.n
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override // v9.n
    public final nc.c h() {
        return this.f13360k;
    }

    @Override // v9.n
    public final boolean i(int i) {
        return i != 0;
    }

    @Override // v9.n
    public final boolean k() {
        return this.f13363n;
    }

    @Override // v9.n
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f13358h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: v9.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    j jVar = this.f13354u;
                    long j5 = jCurrentTimeMillis - jVar.f13364o;
                    if (j5 < 0 || j5 > 300) {
                        jVar.f13362m = false;
                    }
                    jVar.t();
                    jVar.f13362m = true;
                    jVar.f13364o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.f13358h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: v9.i
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                j jVar = this.f13355a;
                jVar.f13362m = true;
                jVar.f13364o = System.currentTimeMillis();
                jVar.s(false);
            }
        });
        this.f13358h.setThreshold(0);
        TextInputLayout textInputLayout = this.f13376a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.f13365p.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = o0.f10475a;
            this.f13379d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // v9.n
    public final void m(r0.e eVar) {
        if (this.f13358h.getInputType() == 0) {
            eVar.i(Spinner.class.getName());
        }
        if (Build.VERSION.SDK_INT >= 26 ? eVar.f11226a.isShowingHintText() : eVar.e(4)) {
            eVar.k(null);
        }
    }

    @Override // v9.n
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.f13365p.isEnabled() && this.f13358h.getInputType() == 0) {
            boolean z2 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f13363n && !this.f13358h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z2) {
                t();
                this.f13362m = true;
                this.f13364o = System.currentTimeMillis();
            }
        }
    }

    @Override // v9.n
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f13357g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f);
        int i = 3;
        valueAnimatorOfFloat.addUpdateListener(new i4.d(i, this));
        this.f13367r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f13356e);
        valueAnimatorOfFloat2.addUpdateListener(new i4.d(i, this));
        this.f13366q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new g5.l(8, this));
        this.f13365p = (AccessibilityManager) this.f13378c.getSystemService("accessibility");
    }

    @Override // v9.n
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.f13358h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f13358h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z2) {
        if (this.f13363n != z2) {
            this.f13363n = z2;
            this.f13367r.cancel();
            this.f13366q.start();
        }
    }

    public final void t() {
        if (this.f13358h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f13364o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.f13362m = false;
        }
        if (this.f13362m) {
            this.f13362m = false;
            return;
        }
        s(!this.f13363n);
        if (!this.f13363n) {
            this.f13358h.dismissDropDown();
        } else {
            this.f13358h.requestFocus();
            this.f13358h.showDropDown();
        }
    }
}
