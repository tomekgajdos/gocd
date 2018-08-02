/*
 * Copyright 2018 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thoughtworks.go.server.domain.user;

import com.thoughtworks.go.config.CaseInsensitiveString;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WhitelistFilter implements DashboardFilter {
    private final String name;
    private final List<CaseInsensitiveString> pipelines;

    public WhitelistFilter(String name, List<CaseInsensitiveString> pipelines) {
        this.name = name;
        this.pipelines = DashboardFilter.enforceList(pipelines);
    }

    public List<CaseInsensitiveString> pipelines() {
        return Collections.unmodifiableList(pipelines);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isPipelineVisible(CaseInsensitiveString pipeline) {
        return null != pipelines && !pipelines.isEmpty() && pipelines.contains(pipeline);
    }

    @Override
    public boolean allowPipeline(CaseInsensitiveString pipeline) {
        return !pipelines.contains(pipeline) && pipelines.add(pipeline);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhitelistFilter that = (WhitelistFilter) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pipelines, that.pipelines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pipelines);
    }
}