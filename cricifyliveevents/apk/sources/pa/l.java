package pa;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10071e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f10072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f10073h;
    public final com.google.android.material.datepicker.n i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f10074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f10075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f10079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AccessibilityManager f10080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ValueAnimator f10081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ValueAnimator f10082r;

    /* JADX WARN: Type inference failed for: r0v2, types: [pa.k] */
    public l(p pVar) {
        super(pVar);
        this.i = new com.google.android.material.datepicker.n(7, this);
        this.f10074j = new a(1, this);
        this.f10075k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: pa.k
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                l lVar = this.f10070a;
                AutoCompleteTextView autoCompleteTextView = lVar.f10073h;
                if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
                    return;
                }
                lVar.f10097d.setImportantForAccessibility(z10 ? 2 : 1);
            }
        };
        this.f10079o = Long.MAX_VALUE;
        this.f = sd.i.C(pVar.getContext(), k9.b.motionDurationShort3, 67);
        this.f10071e = sd.i.C(pVar.getContext(), k9.b.motionDurationShort3, 50);
        this.f10072g = sd.i.D(pVar.getContext(), k9.b.motionEasingLinearInterpolator, l9.a.f7925a);
    }

    @Override // pa.q
    public final void a() {
        if (this.f10080p.isTouchExplorationEnabled() && this.f10073h.getInputType() != 0 && !this.f10097d.hasFocus()) {
            this.f10073h.dismissDropDown();
        }
        this.f10073h.post(new c(1, this));
    }

    @Override // pa.q
    public final int c() {
        return k9.j.exposed_dropdown_menu_content_description;
    }

    @Override // pa.q
    public final int d() {
        return k9.e.mtrl_dropdown_arrow;
    }

    @Override // pa.q
    public final View.OnFocusChangeListener e() {
        return this.f10074j;
    }

    @Override // pa.q
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override // pa.q
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f10075k;
    }

    @Override // pa.q
    public final boolean i(int i) {
        return i != 0;
    }

    @Override // pa.q
    public final boolean k() {
        return this.f10078n;
    }

    @Override // pa.q
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f10073h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: pa.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    l lVar = this.f10068v;
                    long j4 = jUptimeMillis - lVar.f10079o;
                    if (j4 < 0 || j4 > 300) {
                        lVar.f10077m = false;
                    }
                    lVar.t();
                    lVar.f10077m = true;
                    lVar.f10079o = SystemClock.uptimeMillis();
                }
                return false;
            }
        });
        this.f10073h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: pa.j
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                l lVar = this.f10069a;
                lVar.f10077m = true;
                lVar.f10079o = SystemClock.uptimeMillis();
                lVar.s(false);
            }
        });
        this.f10073h.setThreshold(0);
        TextInputLayout textInputLayout = this.f10094a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.f10080p.isTouchExplorationEnabled()) {
            this.f10097d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // pa.q
    public final void m(u0.e eVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = eVar.f12062a;
        if (this.f10073h.getInputType() == 0) {
            eVar.i(Spinner.class.getName());
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 ? accessibilityNodeInfo.isShowingHintText() : eVar.e(4)) {
            if (i >= 26) {
                accessibilityNodeInfo.setHintText(null);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", null);
            }
        }
    }

    @Override // pa.q
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.f10080p.isEnabled() && this.f10073h.getInputType() == 0) {
            boolean z10 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f10078n && !this.f10073h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z10) {
                t();
                this.f10077m = true;
                this.f10079o = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // pa.q
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f10072g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f);
        int i = 3;
        valueAnimatorOfFloat.addUpdateListener(new fa.a(i, this));
        this.f10082r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f10071e);
        valueAnimatorOfFloat2.addUpdateListener(new fa.a(i, this));
        this.f10081q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new ba.f(8, this));
        this.f10080p = (AccessibilityManager) this.f10096c.getSystemService("accessibility");
    }

    @Override // pa.q
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.f10073h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f10073h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z10) {
        if (this.f10078n != z10) {
            this.f10078n = z10;
            this.f10082r.cancel();
            this.f10081q.start();
        }
    }

    public final void t() {
        if (this.f10073h == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f10079o;
        if (jUptimeMillis < 0 || jUptimeMillis > 300) {
            this.f10077m = false;
        }
        if (this.f10077m) {
            this.f10077m = false;
            return;
        }
        s(!this.f10078n);
        if (!this.f10078n) {
            this.f10073h.dismissDropDown();
        } else {
            this.f10073h.requestFocus();
            this.f10073h.showDropDown();
        }
    }
}
