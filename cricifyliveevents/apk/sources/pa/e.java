package pa;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10057e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f10058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f10059h;
    public EditText i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.material.datepicker.n f10060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f10061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f10062l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f10063m;

    public e(p pVar) {
        super(pVar);
        this.f10060j = new com.google.android.material.datepicker.n(6, this);
        this.f10061k = new a(0, this);
        this.f10057e = sd.i.C(pVar.getContext(), k9.b.motionDurationShort3, 100);
        this.f = sd.i.C(pVar.getContext(), k9.b.motionDurationShort3, 150);
        this.f10058g = sd.i.D(pVar.getContext(), k9.b.motionEasingLinearInterpolator, l9.a.f7925a);
        this.f10059h = sd.i.D(pVar.getContext(), k9.b.motionEasingEmphasizedInterpolator, l9.a.f7928d);
    }

    @Override // pa.q
    public final void a() {
        if (this.f10095b.K != null) {
            return;
        }
        s(t());
    }

    @Override // pa.q
    public final int c() {
        return k9.j.clear_text_end_icon_content_description;
    }

    @Override // pa.q
    public final int d() {
        return k9.e.mtrl_ic_cancel;
    }

    @Override // pa.q
    public final View.OnFocusChangeListener e() {
        return this.f10061k;
    }

    @Override // pa.q
    public final View.OnClickListener f() {
        return this.f10060j;
    }

    @Override // pa.q
    public final View.OnFocusChangeListener g() {
        return this.f10061k;
    }

    @Override // pa.q
    public final void l(EditText editText) {
        this.i = editText;
        this.f10094a.setEndIconVisible(t());
    }

    @Override // pa.q
    public final void o(boolean z10) {
        if (this.f10095b.K == null) {
            return;
        }
        s(z10);
    }

    @Override // pa.q
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f10059h);
        valueAnimatorOfFloat.setDuration(this.f);
        final int i = 1;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: pa.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f10050b;

            {
                this.f10050b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        e eVar = this.f10050b;
                        eVar.getClass();
                        eVar.f10097d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        e eVar2 = this.f10050b;
                        eVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = eVar2.f10097d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f10058g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i10 = this.f10057e;
        valueAnimatorOfFloat2.setDuration(i10);
        final int i11 = 0;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: pa.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f10050b;

            {
                this.f10050b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        e eVar = this.f10050b;
                        eVar.getClass();
                        eVar.f10097d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        e eVar2 = this.f10050b;
                        eVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = eVar2.f10097d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f10062l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f10062l.addListener(new d(this, i11));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i10);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: pa.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f10050b;

            {
                this.f10050b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        e eVar = this.f10050b;
                        eVar.getClass();
                        eVar.f10097d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        e eVar2 = this.f10050b;
                        eVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = eVar2.f10097d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.f10063m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new d(this, i));
    }

    @Override // pa.q
    public final void r() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new c(0, this));
        }
    }

    public final void s(boolean z10) {
        boolean z11 = this.f10095b.d() == z10;
        if (z10 && !this.f10062l.isRunning()) {
            this.f10063m.cancel();
            this.f10062l.start();
            if (z11) {
                this.f10062l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f10062l.cancel();
        this.f10063m.start();
        if (z11) {
            this.f10063m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.f10097d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }
}
