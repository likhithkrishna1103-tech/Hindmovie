package com.phisher98.donation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPIKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationManager.kt */
/* JADX INFO: loaded from: /home/likhith/Projects/Hindmovie/animedekho/animedekho/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010J\u001a\u00020\u0013H\u0002J\u0010\u0010K\u001a\u00020I2\b\b\u0002\u0010L\u001a\u00020\u0013J$\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000206\u0018\u00010N2\u0006\u0010O\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010PR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u00020\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u00102\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/phisher98/donation/DonationManager;", "", "<init>", "()V", "testMode", "", "getTestMode", "()Z", "setTestMode", "(Z)V", "testProgressAmount", "", "getTestProgressAmount", "()D", "setTestProgressAmount", "(D)V", "isDialogShowing", "setDialogShowing", "OBFUSCATED_TOKEN", "", "getDecryptedBmcToken", "primaryDonateUrl", "getPrimaryDonateUrl", "()Ljava/lang/String;", "setPrimaryDonateUrl", "(Ljava/lang/String;)V", "primaryButtonText", "getPrimaryButtonText", "setPrimaryButtonText", "secondaryDonateUrl", "getSecondaryDonateUrl", "setSecondaryDonateUrl", "secondaryButtonText", "getSecondaryButtonText", "setSecondaryButtonText", "adSupportUrl", "getAdSupportUrl", "setAdSupportUrl", "adSupportButtonText", "getAdSupportButtonText", "setAdSupportButtonText", "targetAmount", "getTargetAmount", "setTargetAmount", "currency", "getCurrency", "setCurrency", "goalTitle", "getGoalTitle", "setGoalTitle", "goalDescription", "getGoalDescription", "setGoalDescription", "cooldownHours", "", "getCooldownHours", "()I", "setCooldownHours", "(I)V", "PREFS_NAME", "KEY_LAST_SHOWN", "KEY_CACHED_MONTH", "KEY_CACHED_AMOUNT", "KEY_CACHED_SUPPORTERS", "DIALOG_TAG", "gateLock", "isLaunching", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "isCooldownActive", "recordShown", "", "getCurrentMonthName", "checkAndShow", "providerName", "fetchBuyMeACoffeeMonthly", "Lkotlin/Pair;", "accessToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeDekhoProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,457:1\n40#2,11:458\n1#3:469\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n*L\n126#1:458,11\n*E\n"})
public final class DonationManager {

    @NotNull
    private static final String DIALOG_TAG = "phisher_donation_floating_dialog";

    @NotNull
    private static final String KEY_CACHED_AMOUNT = "phisher_donation_cached_amount";

    @NotNull
    private static final String KEY_CACHED_MONTH = "phisher_donation_cached_month";

    @NotNull
    private static final String KEY_CACHED_SUPPORTERS = "phisher_donation_cached_supporters";

    @NotNull
    private static final String KEY_LAST_SHOWN = "phisher_donation_last_shown_v2";

    @NotNull
    private static final String OBFUSCATED_TOKEN = "FREjQw09MzYsBSU+MkIlGykiJzcAKgA2JAwzDGdKewc+ASNKRgALFQsIOCQNPB07UCw5Flc3JxYcKDpuWWlmUhskPSECPEASFyM4JB4pN0JULikeUiA3Cls/LThLfVhvGSQqORkBNTQKIwY/CD4eJ1E7BzMJIDQWHCgTN1p+AHgYJy02Eio2BQs1ODsOPUYgDS8pHhggDg4RKxMKSGpfcBklEzpdKzUJDiEFFh49GSNUOwcOUTckEhIqLRVefl9nCTEDKlwqJhpTNjgjDD4wGR84XwZRNzAWGCwUM1pUcX9GJT0QXCo2BlYhFTRXPh0FDAMAFQ8kCTATKwM4Bn5YXQolLRARKTEVDwknNA08HjdRLCkOGCAZGlsrAxpBeVx4QTEAOl4sGDQbISseUT4OPwwtLhUYNFFmHD8hElt/XkUZCwQlAD8xbhUOAg1ROhhDXE8qNwonFT0mJ0o2AAB4f10lXkIBAxoWEiMJFAIiPB4dOAptCxwMGzMIEiVCdV1sEh09MQ41PGo2A102XR8xJicUHgcpIiEQOAM3HlFvX1glARsrHQA7FigOMEAPKzA7MigrCltYIAU7Az8QUQFBckQZJyw8FkU9DD0IPw8APy0HOD8xKzUOEQ0/AS5eQHpzRCpcPDwHJyhSKFhNIhADNywjJx0uGTwJOS4WawcFd31dHz86WitKPjY7DRsGKUZADDMFMSw9JQwsNwxsVUcKfRoHJBlFVCoSCA0JLCsFA0UtUxg4NwlQbz4gDBxtRgpcAzBYHCc2Nm05Hw0PVTY3PwhXITEaI1cpXVEMCFVdB28EPw9GLRwVMCtVJywAJCMcSDgpaggeDzYzCB1sXGNZZQEnMT0NDyAGLTpfMkk6EQsxPi4QCjw3bgQ1VBxYdVFHPDskCSMUAgpTBgw0ACUsQTAkXjISBSRvLhEVcgt9RXsDIhgGLgQZGFc+DTw1Ghg6ESIMNANbDzMICzILAEUKYEYePTQdDDFsGiEaRjUCIUMdDikmIQAPazE9Cy9eUgB8XQ4INF4LQBRQKAYnCUYCBzpXODoHBTUSOQ0MPAEIZnIfLltEHyohBVUrISAXJ0xDSAJbLDg1KwYlAzYxf1VCZxocXBo7CxATOxQOOhE3IyIXIDIsOjUvBSEzAWlme0hTKkU5PxEkAxkWJjdMDitHOx00LwckPjEdGSsBLmZgS0wyRQAUKyktFiI+BD4tPRY6FA5ZJyw+IC8SKUEddwJfXAlYLEoANAIvEQYpPFEcWTkyMxcSJDU5FSArE2taB0VuHSI7FSI8OREBLVslNgtDOyQ+BCkTDBJnUyQbOXlUWEc4PVwhXVE+LAw5KgwhAUEWVSscGQAMJwpcMCYlcw==";

    @NotNull
    private static final String PREFS_NAME = "phisher_donation_prefs";
    private static volatile boolean isDialogShowing;
    private static volatile boolean isLaunching;
    private static boolean testMode;
    private static double testProgressAmount;

    @NotNull
    public static final DonationManager INSTANCE = new DonationManager();

    @NotNull
    private static String primaryDonateUrl = "https://buymeacoffee.com/phisher98";

    @NotNull
    private static String primaryButtonText = "☕ Keep It Alive";

    @NotNull
    private static String secondaryDonateUrl = "";

    @NotNull
    private static String secondaryButtonText = "⚡ Donate via UPI / Other";

    @NotNull
    private static String adSupportUrl = "https://omg10.com/4/11733824";

    @NotNull
    private static String adSupportButtonText = "🎬 Can't donate? Watch an Ad to Support ↗";
    private static double targetAmount = 100.0d;

    @NotNull
    private static String currency = "$";

    @NotNull
    private static String goalTitle = "Help Keep Phisher Repo Alive";

    @NotNull
    private static String goalDescription = "Support us to keep this extension maintained! Reaching the goal means faster updates and active maintenance. If not, updates will be slow, and the extension could become dead over time.";
    private static int cooldownHours = 24;

    @NotNull
    private static final Object gateLock = new Object();

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$fetchBuyMeACoffeeMonthly$1, reason: invalid class name */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.donation.DonationManager", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {333, 345, 400}, m = "fetchBuyMeACoffeeMonthly", n = {"accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "isoFormat", "page", "res", "$this$fetchBuyMeACoffeeMonthly_u24lambda_u245", "currentYear", "currentMonth", "hasMore", "attempt", "accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "isoFormat", "page", "res", "currentYear", "currentMonth", "hasMore", "attempt", "accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "isoFormat", "page", "$this$fetchBuyMeACoffeeMonthly_u24lambda_u247", "currentYear", "currentMonth", "hasMore"}, nl = {342, 346, 410}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DonationManager.this.fetchBuyMeACoffeeMonthly(null, (Continuation) this);
        }
    }

    private DonationManager() {
    }

    public final boolean getTestMode() {
        return testMode;
    }

    public final void setTestMode(boolean z) {
        testMode = z;
    }

    public final double getTestProgressAmount() {
        return testProgressAmount;
    }

    public final void setTestProgressAmount(double d) {
        testProgressAmount = d;
    }

    public final boolean isDialogShowing() {
        return isDialogShowing;
    }

    public final void setDialogShowing(boolean z) {
        isDialogShowing = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDecryptedBmcToken() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DonationManager donationManager = this;
            byte[] salt = "phisher_cloudstream_bmc_key_2026".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(salt, "getBytes(...)");
            byte[] bytes = MainAPIKt.base64DecodeArray(OBFUSCATED_TOKEN);
            byte[] result = new byte[bytes.length];
            int length = bytes.length;
            for (int i = 0; i < length; i++) {
                result[i] = (byte) (bytes[i] ^ salt[i % salt.length]);
            }
            obj = Result.constructor-impl(new String(result, Charsets.UTF_8));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        return (String) obj;
    }

    @NotNull
    public final String getPrimaryDonateUrl() {
        return primaryDonateUrl;
    }

    public final void setPrimaryDonateUrl(@NotNull String str) {
        primaryDonateUrl = str;
    }

    @NotNull
    public final String getPrimaryButtonText() {
        return primaryButtonText;
    }

    public final void setPrimaryButtonText(@NotNull String str) {
        primaryButtonText = str;
    }

    @NotNull
    public final String getSecondaryDonateUrl() {
        return secondaryDonateUrl;
    }

    public final void setSecondaryDonateUrl(@NotNull String str) {
        secondaryDonateUrl = str;
    }

    @NotNull
    public final String getSecondaryButtonText() {
        return secondaryButtonText;
    }

    public final void setSecondaryButtonText(@NotNull String str) {
        secondaryButtonText = str;
    }

    @NotNull
    public final String getAdSupportUrl() {
        return adSupportUrl;
    }

    public final void setAdSupportUrl(@NotNull String str) {
        adSupportUrl = str;
    }

    @NotNull
    public final String getAdSupportButtonText() {
        return adSupportButtonText;
    }

    public final void setAdSupportButtonText(@NotNull String str) {
        adSupportButtonText = str;
    }

    public final void setTargetAmount(double d) {
        targetAmount = d;
    }

    public final double getTargetAmount() {
        try {
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            int year = cal.get(1);
            int month = cal.get(2);
            if (year > 2026 || (year == 2026 && month >= 9)) {
                return 200.0d;
            }
            return 100.0d;
        } catch (Throwable th) {
            return targetAmount;
        }
    }

    @NotNull
    public final String getCurrency() {
        return currency;
    }

    public final void setCurrency(@NotNull String str) {
        currency = str;
    }

    @NotNull
    public final String getGoalTitle() {
        return goalTitle;
    }

    public final void setGoalTitle(@NotNull String str) {
        goalTitle = str;
    }

    @NotNull
    public final String getGoalDescription() {
        return goalDescription;
    }

    public final void setGoalDescription(@NotNull String str) {
        goalDescription = str;
    }

    public final int getCooldownHours() {
        return cooldownHours;
    }

    public final void setCooldownHours(int i) {
        cooldownHours = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREFS_NAME, 0);
    }

    private final boolean isCooldownActive(Context context) {
        if (testMode) {
            return false;
        }
        SharedPreferences prefs = getPrefs(context);
        long lastShown = prefs.getLong(KEY_LAST_SHOWN, 0L);
        if (lastShown <= 0) {
            return false;
        }
        long cooldownMillis = ((long) cooldownHours) * 60 * 60 * 1000;
        long elapsed = System.currentTimeMillis() - lastShown;
        return elapsed < cooldownMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordShown(Context context) {
        SharedPreferences $this$edit$iv = getPrefs(context);
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putLong(KEY_LAST_SHOWN, System.currentTimeMillis());
        editor$iv.apply();
    }

    private final String getCurrentMonthName() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy", Locale.US);
        return format.format(cal.getTime());
    }

    public static /* synthetic */ void checkAndShow$default(DonationManager donationManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        donationManager.checkAndShow(str);
    }

    public final void checkAndShow(@NotNull String providerName) {
        Context context = CloudStreamApp.Companion.getContext();
        if (context == null) {
            Activity activity = CommonActivity.INSTANCE.getActivity();
            context = activity != null ? activity.getApplicationContext() : null;
            if (context == null) {
                return;
            }
        }
        Context appContext = context;
        String currentMonth = getCurrentMonthName();
        synchronized (gateLock) {
            if (!isLaunching && !isDialogShowing && !INSTANCE.isCooldownActive(appContext)) {
                isLaunching = true;
                Unit unit = Unit.INSTANCE;
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(appContext, currentMonth, providerName, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2, reason: invalid class name */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {202, 218, 219, 265}, m = "invokeSuspend", n = {"prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "attempt", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "attempt", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "dynamicTitle", "config", "hasCachedData", "isGoalAchieved"}, nl = {203, 219, 220, 292}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,457:1\n40#2,11:458\n40#2,11:469\n40#2,11:480\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n*L\n169#1:458,11\n207#1:469,11\n224#1:480,11\n*E\n"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ String $currentMonth;
        final /* synthetic */ String $providerName;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$appContext = context;
            this.$currentMonth = str;
            this.$providerName = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$appContext, this.$currentMonth, this.$providerName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:128:0x030a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:129:0x02aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:136:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:62:0x024f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x0250  */
        /* JADX WARN: Code duplicated, block: B:66:0x0264 A[Catch: all -> 0x031a, TRY_LEAVE, TryCatch #6 {all -> 0x031a, blocks: (B:58:0x021b, B:64:0x025b, B:66:0x0264), top: B:136:0x021b }] */
        /* JADX WARN: Code duplicated, block: B:70:0x0288 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:71:0x0289  */
        /* JADX WARN: Code duplicated, block: B:76:0x02a1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0289 -> B:138:0x0292). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x02a1 -> B:77:0x02a8). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r41) {
            /*
                Method dump skipped, instruction units count: 1124
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2$2", f = "DonationManager.kt", i = {0, 0}, l = {187}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240"}, nl = {188}, s = {"L$0", "L$3"}, v = 2)
        @SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,457:1\n40#2,11:458\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2$2\n*L\n189#1:458,11\n*E\n"})
        static final class C00002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $currentMonth;
            final /* synthetic */ SharedPreferences $prefs;
            final /* synthetic */ String $token;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00002(String str, SharedPreferences sharedPreferences, String str2, Continuation<? super C00002> continuation) {
                super(2, continuation);
                this.$token = str;
                this.$prefs = sharedPreferences;
                this.$currentMonth = str2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00002 = new C00002(this.$token, this.$prefs, this.$currentMonth, continuation);
                c00002.L$0 = obj;
                return c00002;
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:18:0x0060 A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:7:0x0022, B:16:0x005b, B:18:0x0060, B:20:0x009c, B:10:0x0031, B:12:0x003e), top: B:26:0x000a }] */
            public final Object invokeSuspend(Object $result) {
                SharedPreferences $this$edit$iv;
                String str;
                Object objFetchBuyMeACoffeeMonthly;
                int i;
                Pair fresh;
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            String str2 = this.$token;
                            $this$edit$iv = this.$prefs;
                            str = this.$currentMonth;
                            Result.Companion companion = Result.Companion;
                            if (!StringsKt.isBlank(str2)) {
                                DonationManager donationManager = DonationManager.INSTANCE;
                                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                                this.L$1 = $this$edit$iv;
                                this.L$2 = str;
                                this.L$3 = SpillingKt.nullOutSpilledVariable($this$launch);
                                this.label = 1;
                                objFetchBuyMeACoffeeMonthly = donationManager.fetchBuyMeACoffeeMonthly(str2, this);
                                if (objFetchBuyMeACoffeeMonthly == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                i = 0;
                                fresh = (Pair) objFetchBuyMeACoffeeMonthly;
                                if (fresh != null) {
                                    SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
                                    Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
                                    editor$iv.putString(DonationManager.KEY_CACHED_MONTH, str).putFloat(DonationManager.KEY_CACHED_AMOUNT, (float) ((Number) fresh.getFirst()).doubleValue()).putInt(DonationManager.KEY_CACHED_SUPPORTERS, ((Number) fresh.getSecond()).intValue());
                                    editor$iv.apply();
                                }
                            }
                            Result.constructor-impl(Unit.INSTANCE);
                            return Unit.INSTANCE;
                        case 1:
                            i = 0;
                            str = (String) this.L$2;
                            $this$edit$iv = (SharedPreferences) this.L$1;
                            ResultKt.throwOnFailure($result);
                            objFetchBuyMeACoffeeMonthly = $result;
                            fresh = (Pair) objFetchBuyMeACoffeeMonthly;
                            if (fresh != null) {
                                SharedPreferences.Editor editor$iv2 = $this$edit$iv.edit();
                                Intrinsics.checkExpressionValueIsNotNull(editor$iv2, "editor");
                                editor$iv2.putString(DonationManager.KEY_CACHED_MONTH, str).putFloat(DonationManager.KEY_CACHED_AMOUNT, (float) ((Number) fresh.getFirst()).doubleValue()).putInt(DonationManager.KEY_CACHED_SUPPORTERS, ((Number) fresh.getSecond()).intValue());
                                editor$iv2.apply();
                            }
                            Result.constructor-impl(Unit.INSTANCE);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2$5", f = "DonationManager.kt", i = {0, 0}, l = {272}, m = "invokeSuspend", n = {"currentActivity", "i"}, nl = {273}, s = {"L$0", "I$0"}, v = 2)
        static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $appContext;
            final /* synthetic */ DonationConfig $config;
            int I$0;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(Context context, DonationConfig donationConfig, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$appContext = context;
                this.$config = donationConfig;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$appContext, this.$config, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:25:0x0053  */
            /* JADX WARN: Code duplicated, block: B:27:0x0070 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:30:0x007b  */
            /* JADX WARN: Code duplicated, block: B:31:0x007e  */
            /* JADX WARN: Code duplicated, block: B:34:0x0082  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006e -> B:28:0x0071). Please report as a decompilation issue!!! */
            /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
                java.lang.StackOverflowError
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
                */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    Method dump skipped, instruction units count: 246
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.AnonymousClass2.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            static final Unit invokeSuspend$lambda$0() {
                DonationManager.INSTANCE.setDialogShowing(false);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:321:0x025d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0317 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0318  */
    /* JADX WARN: Code duplicated, block: B:79:0x042f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:82:0x0437 A[Catch: all -> 0x04c1, TryCatch #15 {all -> 0x04c1, blocks: (B:77:0x0429, B:80:0x0431, B:82:0x0437, B:84:0x0443), top: B:343:0x0429 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0443 A[Catch: all -> 0x04c1, TRY_LEAVE, TryCatch #15 {all -> 0x04c1, blocks: (B:77:0x0429, B:80:0x0431, B:82:0x0437, B:84:0x0443), top: B:343:0x0429 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x047b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x047c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0229 -> B:38:0x0257). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x047c -> B:88:0x048c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object fetchBuyMeACoffeeMonthly(java.lang.String r75, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Double, java.lang.Integer>> r76) {
        /*
            Method dump skipped, instruction units count: 2764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.fetchBuyMeACoffeeMonthly(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Date fetchBuyMeACoffeeMonthly$parseDate(SimpleDateFormat dateFormat, SimpleDateFormat isoFormat, String raw) {
        Object obj;
        Object obj2;
        Object obj3;
        if (StringsKt.isBlank(raw)) {
            return null;
        }
        String clean = StringsKt.trim(raw).toString();
        if (new Regex("\\d+").matches(clean)) {
            long millis = Long.parseLong(clean) * (clean.length() > 10 ? 1L : 1000L);
            DonationManager donationManager = INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                obj3 = Result.constructor-impl(new Date(millis));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return (Date) (Result.isFailure-impl(obj3) ? null : obj3);
        }
        DonationManager donationManager2 = INSTANCE;
        try {
            Result.Companion companion3 = Result.Companion;
            obj = Result.constructor-impl(dateFormat.parse(clean));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Date date = (Date) obj;
        if (date != null) {
            return date;
        }
        DonationManager donationManager3 = INSTANCE;
        try {
            Result.Companion companion5 = Result.Companion;
            obj2 = Result.constructor-impl(isoFormat.parse(StringsKt.substringBefore$default(clean, '.', (String) null, 2, (Object) null)));
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        return (Date) (Result.isFailure-impl(obj2) ? null : obj2);
    }
}
