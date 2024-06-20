package com.company.project.utils;

import com.company.project.vo.LockVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RedisServiceImplTest {

    @Mock
    private RedisTemplate<String, Object> mockRedisTemplate;
    @Mock
    private RedisTemplate mockStringRedisTemplate;

    @InjectMocks
    private RedisServiceImpl redisServiceImplUnderTest;

    @Test
    public void testBatchGet() {
        // Setup
        when(mockStringRedisTemplate.executePipelined(any(RedisCallback.class))).thenReturn(Arrays.asList());

        // Run the test
        final List<String> result = redisServiceImplUnderTest.batchGet(Arrays.asList("value"));

        // Verify the results
        assertThat(result).isEqualTo(Arrays.asList("value"));
    }

    @Test
    public void testBatchGet_RedisTemplateReturnsNoItems() {
        // Setup
        when(mockStringRedisTemplate.executePipelined(any(RedisCallback.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<String> result = redisServiceImplUnderTest.batchGet(Arrays.asList("value"));

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testBatchQueryByKeys() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);
        when(mockStringRedisTemplate.executePipelined(any(RedisCallback.class))).thenReturn(Arrays.asList());

        // Run the test
        final Map<String, Object> result = redisServiceImplUnderTest.batchQueryByKeys(Arrays.asList("value"), false);

        // Verify the results
    }

    @Test
    public void testBatchQueryByKeys_StringRedisTemplateReturnsNull() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);
        when(mockStringRedisTemplate.executePipelined(any(RedisCallback.class))).thenReturn(null);

        // Run the test
        final Map<String, Object> result = redisServiceImplUnderTest.batchQueryByKeys(Arrays.asList("value"), false);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    public void testBatchQueryByKeys_StringRedisTemplateReturnsNoItems() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);
        when(mockStringRedisTemplate.executePipelined(any(RedisCallback.class))).thenReturn(Collections.emptyList());

        // Run the test
        final Map<String, Object> result = redisServiceImplUnderTest.batchQueryByKeys(Arrays.asList("value"), false);

        // Verify the results
    }

    @Test
    public void testBatchDelete() {
        // Setup
        // Run the test
        redisServiceImplUnderTest.batchDelete("key");

        // Verify the results
        verify(mockRedisTemplate).delete("key");
        verify(mockRedisTemplate).delete(Arrays.asList("value"));
    }

    @Test
    public void testSetData1() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.setData("key", 0L);

        // Verify the results
    }

    @Test
    public void testSet() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.set("key", "value");

        // Verify the results
    }

    @Test
    public void testExpire1() {
        // Setup
        when(mockRedisTemplate.getExpire("key", TimeUnit.SECONDS)).thenReturn(0L);

        // Run the test
        final Long result = redisServiceImplUnderTest.expire("key");

        // Verify the results
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void testExpireMillisecond() {
        // Setup
        when(mockRedisTemplate.getExpire("key", TimeUnit.MILLISECONDS)).thenReturn(0L);

        // Run the test
        final Long result = redisServiceImplUnderTest.expireMillisecond("key");

        // Verify the results
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void testSetWithExpire() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.setWithExpire("key", "value", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testSetDay() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.setDay("key", "value", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.DAYS);
    }

    @Test
    public void testGet() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        final Object result = redisServiceImplUnderTest.get("key");

        // Verify the results
    }

    @Test
    public void testIncrement() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        final Long result = redisServiceImplUnderTest.increment("key", 0L);

        // Verify the results
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void testHMSet1() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.HMSet("key", "key", "value", false);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.SECONDS);
    }

    @Test
    public void testHMSet2() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.HMSet("key", "key", "value", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.HOURS);
    }

    @Test
    public void testHMincrement() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        final Long result = redisServiceImplUnderTest.HMincrement("str", "key", 0L);

        // Verify the results
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void testHMGet() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        final Object result = redisServiceImplUnderTest.HMGet("str", "key");

        // Verify the results
    }

    @Test
    public void testExpire2() {
        // Setup
        // Run the test
        redisServiceImplUnderTest.expire("key", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testExpireSeconds() {
        // Setup
        // Run the test
        redisServiceImplUnderTest.expireSeconds("key", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.SECONDS);
    }

    @Test
    public void testExpireHours() {
        // Setup
        // Run the test
        redisServiceImplUnderTest.expireHours("key", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.HOURS);
    }

    @Test
    public void testExpireDay() {
        // Setup
        // Run the test
        redisServiceImplUnderTest.expireDay("key", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("key", 0L, TimeUnit.DAYS);
    }

    @Test
    public void testExistKey() {
        // Setup
        when(mockRedisTemplate.hasKey("key")).thenReturn(false);

        // Run the test
        final boolean result = redisServiceImplUnderTest.existKey("key");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    public void testExistKey_RedisTemplateReturnsTrue() {
        // Setup
        when(mockRedisTemplate.hasKey("key")).thenReturn(true);

        // Run the test
        final boolean result = redisServiceImplUnderTest.existKey("key");

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    public void testHMexistKey() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        final boolean result = redisServiceImplUnderTest.HMexistKey("key", "obj");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        when(mockRedisTemplate.hasKey("key")).thenReturn(false);

        // Run the test
        redisServiceImplUnderTest.delete("key");

        // Verify the results
    }

    @Test
    public void testDelete_RedisTemplateHasKeyReturnsTrue() {
        // Setup
        when(mockRedisTemplate.hasKey("key")).thenReturn(true);

        // Run the test
        redisServiceImplUnderTest.delete("key");

        // Verify the results
        verify(mockRedisTemplate).delete("key");
    }

    @Test
    public void testHMDelete() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.HMDelete("str1", "str2");

        // Verify the results
    }

    @Test
    public void testMultiGet() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        final List<Object> result = redisServiceImplUnderTest.multiGet("user", Arrays.asList("value"));

        // Verify the results
    }

    @Test
    public void testGetValues() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        final List<Object> result = redisServiceImplUnderTest.getValues("key");

        // Verify the results
    }

    @Test
    public void testLike() {
        // Setup
        when(mockRedisTemplate.keys("pattern")).thenReturn(new HashSet<>(Arrays.asList("value")));

        // Run the test
        final Set<String> result = redisServiceImplUnderTest.like("pattern");

        // Verify the results
        assertThat(result).isEqualTo(new HashSet<>(Arrays.asList("value")));
    }

    @Test
    public void testLike_RedisTemplateReturnsNoItems() {
        // Setup
        when(mockRedisTemplate.keys("pattern")).thenReturn(Collections.emptySet());

        // Run the test
        final Set<String> result = redisServiceImplUnderTest.like("pattern");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptySet());
    }

    @Test
    public void testGetSet() {
        // Setup
        when(mockRedisTemplate.opsForSet()).thenReturn(null);

        // Run the test
        final Set<Object> result = redisServiceImplUnderTest.getSet("key");

        // Verify the results
    }

    @Test
    public void testPut() {
        // Setup
        when(mockRedisTemplate.opsForHash()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.put("redisKey", "key", "doamin", 0L);

        // Verify the results
        verify(mockRedisTemplate).expire("redisKey", 0L, TimeUnit.SECONDS);
    }

    @Test
    public void testSetData2() {
        // Setup
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        redisServiceImplUnderTest.setData("key", "value", 0L, TimeUnit.MILLISECONDS);

        // Verify the results
    }

    @Test
    public void testTryLock() {
        // Setup
        final LockVo lock = new LockVo("key", "value");
        when(mockRedisTemplate.hasKey("key")).thenReturn(false);
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        final boolean result = redisServiceImplUnderTest.tryLock(lock);

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    public void testTryLock_RedisTemplateHasKeyReturnsTrue() {
        // Setup
        final LockVo lock = new LockVo("key", "value");
        when(mockRedisTemplate.hasKey("key")).thenReturn(true);

        // Run the test
        final boolean result = redisServiceImplUnderTest.tryLock(lock);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    public void testGetLock() {
        // Setup
        final LockVo lock = new LockVo("key", "value");
        when(mockRedisTemplate.hasKey("key")).thenReturn(false);
        when(mockRedisTemplate.opsForValue()).thenReturn(null);

        // Run the test
        final boolean result = redisServiceImplUnderTest.getLock(lock, 0L, 0L, 0L);

        // Verify the results
        assertThat(result).isTrue();
    }

    @Test
    public void testGetLock_RedisTemplateHasKeyReturnsTrue() {
        // Setup
        final LockVo lock = new LockVo("key", "value");
        when(mockRedisTemplate.hasKey("key")).thenReturn(true);

        // Run the test
        final boolean result = redisServiceImplUnderTest.getLock(lock, 0L, 0L, 0L);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    public void testReleaseLock() {
        // Setup
        final LockVo lock = new LockVo("key", "value");
        when(mockRedisTemplate.hasKey("key")).thenReturn(false);

        // Run the test
        redisServiceImplUnderTest.releaseLock(lock);

        // Verify the results
    }

    @Test
    public void testReleaseLock_RedisTemplateHasKeyReturnsTrue() {
        // Setup
        final LockVo lock = new LockVo("key", "value");
        when(mockRedisTemplate.hasKey("key")).thenReturn(true);

        // Run the test
        redisServiceImplUnderTest.releaseLock(lock);

        // Verify the results
        verify(mockRedisTemplate).delete("key");
    }
}
